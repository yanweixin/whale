plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("me.whale.kotlin-common-conventions")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.bootJar {
    enabled = false
}

tasks.bootRun {
    enabled = false
}