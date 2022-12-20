plugins {
    id("me.whale.kotlin-application-conventions")
}

dependencies {
    implementation(project(":whale-library:whale-rpc-starter"))
    implementation("io.grpc:grpc-protobuf")
    implementation("io.grpc:grpc-stub")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53") // necessary for Java 9+
    runtimeOnly("io.grpc:grpc-netty-shaded")
    testImplementation("io.grpc:grpc-testing")
}