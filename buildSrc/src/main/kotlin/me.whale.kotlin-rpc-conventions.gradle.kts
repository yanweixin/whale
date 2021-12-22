plugins {
    id("me.whale.kotlin-application-conventions")
}

dependencies {
    implementation("me.whale:whale-rpc-starter:0.0.1-SNAPSHOT")
    implementation("io.grpc:grpc-protobuf")
    implementation("io.grpc:grpc-stub")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53") // necessary for Java 9+
    runtimeOnly("io.grpc:grpc-netty-shaded")
    testImplementation("io.grpc:grpc-testing")
}