plugins {
    id("me.whale.kotlin-library-conventions")
}

val grpcVersion: String by rootProject.extra

dependencies {
    implementation("io.grpc:grpc-api:${grpcVersion}")
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
}
