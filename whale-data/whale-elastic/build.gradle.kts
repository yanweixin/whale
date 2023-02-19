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


dependencies {
//    implementation("org.elasticsearch.client:elasticsearch-rest-client:${elasticVersion}")
    implementation("co.elastic.clients:elasticsearch-java")
    implementation("com.fasterxml.jackson.core:jackson-databind")
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