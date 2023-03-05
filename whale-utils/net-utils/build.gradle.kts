plugins {
    id("me.whale.kotlin-library-conventions")
}

dependencies {
    implementation("io.netty:netty-all")
    implementation("com.squareup.okhttp3:okhttp")
    runtimeOnly("io.netty", "netty-resolver-dns-native-macos", null, null, "osx-x86_64")
}