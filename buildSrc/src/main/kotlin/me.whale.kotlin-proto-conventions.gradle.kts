import com.google.protobuf.gradle.*

plugins {
    id("me.whale.kotlin-common-conventions")
    id("com.google.protobuf")
}

dependencies {
    implementation("io.grpc:grpc-protobuf")
    implementation("io.grpc:grpc-stub")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53") // necessary for Java 9+
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java"
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