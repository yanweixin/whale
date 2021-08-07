/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("me.whale.kotlin-common-conventions")

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            afterEvaluate {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version
            }
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("My Library")
                description.set("A concise description of my library")
                url.set("http://www.example.com/library")
                properties.set(
                    mapOf(
                        "myProp" to "value",
                        "prop.with.dots" to "anotherValue"
                    )
                )
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("whale")
                        name.set("Big Whale")
                        email.set("big.whale@example.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://example.com/my-library.git")
                    developerConnection.set("scm:git:ssh://example.com/my-library.git")
                    url.set("http://example.com/my-library/")
                }
            }
        }
    }
}
