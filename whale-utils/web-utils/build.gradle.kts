plugins {
    id("me.whale.kotlin-library-conventions")
}

val nettyVersion by extra("4.1.68.Final")
val okhttpVersion by extra("4.9.1")

dependencies {
    implementation("io.netty:netty-all:${nettyVersion}")
    implementation("com.squareup.okhttp3:okhttp:${okhttpVersion}")
}