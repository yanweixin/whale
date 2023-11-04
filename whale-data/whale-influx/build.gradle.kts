plugins {
    id("me.whale.kotlin-common-conventions")
}

val influxdbVersion by extra("6.7.0")

dependencies {
    implementation("com.influxdb:influxdb-client-java:${influxdbVersion}")
}