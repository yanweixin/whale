plugins {
    id("me.whale.kotlin-rpc-conventions")
}

val elasticVersion by extra("7.14.0")

dependencies {
    implementation("org.elasticsearch.client:elasticsearch-rest-client:${elasticVersion}")
    implementation("org.elasticsearch.client:elasticsearch-rest-high-level-client:${elasticVersion}")
}