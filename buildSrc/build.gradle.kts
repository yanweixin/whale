/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
    google()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

val jmhGradleVersion: String by project
val springBootVersion: String by project
val protobufGradleVersion: String by project
val shadowVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    implementation("org.jetbrains.kotlin:kotlin-noarg")
    implementation("org.jetbrains.kotlin:kotlin-allopen")
    implementation("org.springframework.boot", "spring-boot-gradle-plugin", springBootVersion)
//    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.5.2"))
    implementation("me.champeau.jmh", "jmh-gradle-plugin", jmhGradleVersion)
    implementation("gradle.plugin.com.github.johnrengelman", "shadow", shadowVersion)
    implementation("com.google.protobuf", "protobuf-gradle-plugin", protobufGradleVersion)
    implementation("org.jlleitschuh.gradle.ktlint:org.jlleitschuh.gradle.ktlint.gradle.plugin:10.3.0")
}
