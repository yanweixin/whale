pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    resolutionStrategy {
        eachPlugin {
//            when (requested.id.namespace) {
//                "org.gradle.kotlin" -> {
//                    val kotlinDslVersion: String by settings
//                    useVersion(kotlinDslVersion)
//                    if (requested.version != kotlinDslVersion) {
//                        println(kotlinDslVersion + ";" + requested.version)
//                    }
//                }
//            }
        }
    }
}