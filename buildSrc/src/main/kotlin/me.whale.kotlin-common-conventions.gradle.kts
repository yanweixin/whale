import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm")
    id("me.champeau.jmh")
    id("com.github.johnrengelman.shadow")
}
apply<me.whale.gradle.WhalePlugin>()

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("http://nexus.whale.io:8081/repository/maven-public/")
        isAllowInsecureProtocol = true
    }
}

group = "me.whale"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

val junitVersion: String by rootProject.extra
val assertjVersion: String by rootProject.extra
val jmhVersion: String by rootProject.extra
val springVersion: String by rootProject.extra
val log4jVersion: String by rootProject.extra
val slf4jVersion: String by rootProject.extra

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.apache.commons:commons-text:${rootProject.extra["commonTextVersion"]}")
        implementation("org.apache.commons:commons-math:3.6.1")
        implementation("org.apache.commons:commons-lang3:${rootProject.extra["commonsLangVersion"]}")
        implementation("commons-io:commons-io:${rootProject.extra["commonIoVersion"]}")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("com.fasterxml.jackson.core:jackson-databind:${rootProject.extra["jacksonVersion"]}")
    }

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation("org.apache.logging.log4j", "log4j-slf4j-impl", log4jVersion)
    implementation("org.apache.logging.log4j", "log4j-core", log4jVersion)
    implementation("org.apache.logging.log4j", "log4j-jul", log4jVersion)
    implementation("org.slf4j", "jul-to-slf4j", slf4jVersion)
    compileOnly("jakarta.inject:jakarta.inject-api:1.0")

    // Use JUnit Jupiter API for testing.
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:${assertjVersion}")
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
        jvmTarget = "17"
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(listOf("-Xlint:unchecked"))
    options.isDeprecation = true
}

tasks.withType<Test> {
    File("$rootDir/config/.env").forEachLine {
        if (it.isNotBlank() && !it.startsWith("#")) {
            val (key, value) = it.split("=")
            if (System.getenv(key) == null) {
                environment(key, value)
            }
        }
    }
}

tasks.withType<JavaExec> {
    rootProject.file("config/.env").forEachLine {
        if (it.isNotBlank() && !it.startsWith("#")) {
            val (key, value) = it.split("=")
            if (System.getenv(key) == null) {
                environment(key, value)
            }
        }
    }
}

tasks.processResources {
    from("$rootDir/config/resources") {
        filter(org.apache.tools.ant.filters.FixCrLfFilter::class)
        filter(org.apache.tools.ant.filters.ReplaceTokens::class, "tokens" to mapOf("whale" to project.name))
    }
}

tasks.shadowJar {
    enabled = false
}