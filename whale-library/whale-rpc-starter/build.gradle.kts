plugins {
    id("me.whale.kotlin-library-conventions")
}

val grpcVersion: String by rootProject.extra

dependencies {
    implementation("io.grpc:grpc-api:${grpcVersion}")
    implementation(project(":whale-utils:pure-utils"))
}
