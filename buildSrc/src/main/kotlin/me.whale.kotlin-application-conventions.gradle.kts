/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("me.whale.kotlin-common-conventions")

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

application {
    applicationDefaultJvmArgs = listOf(
        "-Dfile.encoding=UTF-8",
        "-XX:+HeapDumpOnOutOfMemoryError", "-Xms128m", "-Xmx512m",
        "-XX:+UseDynamicNumberOfGCThreads", "-XX:+UseZGC"
    )
}