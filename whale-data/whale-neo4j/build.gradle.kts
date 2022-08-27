plugins {
    id("me.whale.kotlin-rpc-conventions")
}

val neo4jVersion by extra("4.4.9")

dependencies {
    implementation("org.neo4j.driver:neo4j-java-driver:${neo4jVersion}")
}