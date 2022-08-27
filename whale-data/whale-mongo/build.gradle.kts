plugins {
    id("me.whale.kotlin-rpc-conventions")
}

val mongodbVersion by extra("4.7.1")

dependencies {
    implementation("org.mongodb:mongodb-driver-sync:${mongodbVersion}")
}