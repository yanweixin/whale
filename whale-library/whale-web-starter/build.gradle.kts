plugins {
    id("me.whale.kotlin-library-conventions")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
    implementation("me.whale:common-utils:0.0.1-SNAPSHOT")
    implementation("me.whale:whale-log:0.0.1-SNAPSHOT")
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    compileOnly("org.springframework:spring-web")
    compileOnly("org.hibernate.validator:hibernate-validator")
    compileOnly("jakarta.servlet:jakarta.servlet-api")
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    archiveClassifier.set("") // to remove 'plain' from jar file
}