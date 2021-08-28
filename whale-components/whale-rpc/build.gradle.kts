plugins {
    id("me.whale.kotlin-library-conventions")
}

val grpcVersion by extra("1.39.0")

dependencies {
    implementation("io.grpc:grpc-api:${grpcVersion}")
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
}
