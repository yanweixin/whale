plugins {
    id("me.whale.kotlin-rpc-conventions")
}

repositories {
    mavenCentral()
    maven {
        name = "Elastic-Snapshots"
        url = uri("https://snapshots.elastic.co/maven")
    }
}

val elasticVersion: String by rootProject.extra
val jacksonVersion: String by rootProject.extra

dependencies {
//    implementation("org.elasticsearch.client:elasticsearch-rest-client:${elasticVersion}")
    implementation("co.elastic.clients:elasticsearch-java:${elasticVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")
    implementation(project(":whale-library:whale-data-api"))
}

tasks.shadowJar {
    enabled = true
    // In order to avoid version conflicts
    relocate("org.apache.http", "hidden.org.apache.http")
    relocate("org.apache.logging", "hidden.org.apache.logging")
    relocate("org.apache.commons.codec", "hidden.org.apache.commons.codec")
    relocate("org.apache.commons.logging", "hidden.org.apache.commons.logging")
}

application {
    mainClass.set("me.whale.data.elastic.ElasticApplication")
}