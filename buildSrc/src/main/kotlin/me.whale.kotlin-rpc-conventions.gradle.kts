plugins {
    id("me.whale.kotlin-application-conventions")
}

val grpcVersion: String by rootProject.extra

dependencies {
    implementation("me.whale:whale-rpc:0.0.1-SNAPSHOT")
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("io.grpc:grpc-stub:${grpcVersion}")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53") // necessary for Java 9+
    runtimeOnly("io.grpc:grpc-netty-shaded:${grpcVersion}")
    testImplementation("io.grpc:grpc-testing:${grpcVersion}")
}