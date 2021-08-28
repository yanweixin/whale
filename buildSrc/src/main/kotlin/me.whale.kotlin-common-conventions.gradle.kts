import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm")
    id("me.champeau.jmh")
    id("com.github.johnrengelman.shadow")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    mavenLocal()
}

group = "me.whale"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

val junitVersion by extra("5.7.2")
val jmhVersion by extra("1.32")

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.apache.commons:commons-text:1.9")
        implementation("org.apache.commons:commons-math:3.6.1")
        implementation("org.apache.commons:commons-lang3:3.12.0")
        implementation("commons-io:commons-io:2.10.0")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter-log4j2:2.5.4")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${junitVersion}")
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.20.2")
    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")

    jmh("org.openjdk.jmh:jmh-core:${jmhVersion}")
    jmh("org.openjdk.jmh:jmh-generator-annprocess:${jmhVersion}")
    jmh("org.openjdk.jmh:jmh-generator-reflection:${jmhVersion}")
}

jmh {
    duplicateClassesStrategy.set(DuplicatesStrategy.EXCLUDE)
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
//        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    File("./config/.env").forEachLine {
        if (it.isNotBlank() && !it.startsWith("#")) {
            val (key, value) = it.split("=")
            if (System.getenv(key) == null) {
                environment(key, value)
            }
        }
    }
}

tasks.withType<JavaExec> {
    File("./config/.env").forEachLine {
        if (it.isNotBlank() && !it.startsWith("#")) {
            val (key, value) = it.split("=")
            if (System.getenv(key) == null) {
                environment(key, value)
            }
        }
    }
}

tasks.processResources {
    from("$rootDir/config/resources")
}

tasks.shadowJar {
    enabled = false
}