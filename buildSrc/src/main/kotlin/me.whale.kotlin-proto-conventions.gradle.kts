import com.google.protobuf.gradle.*

plugins {
    id("me.whale.kotlin-common-conventions")
    id("com.google.protobuf")
}

val grpcVersion by extra("1.39.0")
val protocVersion by extra("3.17.2")

dependencies {
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("io.grpc:grpc-stub:${grpcVersion}")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53") // necessary for Java 9+
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${protocVersion}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

//java.sourceSets.getByName("main") {
//    java.srcDir("build/generated/source/proto/main/grpc")
//    java.srcDir("build/generated/source/proto/main/java")
//}
java.sourceSets.main {
    java.srcDirs(
        "build/generated/source/proto/main/grpc",
        "build/generated/source/proto/main/java"
    )
}