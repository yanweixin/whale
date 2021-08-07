plugins {
    id("me.whale.kotlin-application-conventions")
    id("com.google.protobuf")
}

val grpcVersion by extra("1.39.0")

dependencies {
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("io.grpc:grpc-stub:${grpcVersion}")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53") // necessary for Java 9+
    runtimeOnly("io.grpc:grpc-netty-shaded:${grpcVersion}")
    testImplementation("io.grpc:grpc-testing:${grpcVersion}")
}