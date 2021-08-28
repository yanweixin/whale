plugins {
    id("me.whale.kotlin-library-conventions")
}

val nettyVersion by extra("4.1.67.Final")

dependencies {
    implementation("io.netty:netty-all:${nettyVersion}")
}