plugins {
    id("me.whale.kotlin-web-conventions")
}

dependencies {
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
    implementation("me.whale:whale-cache:0.0.1-SNAPSHOT")
}

springBoot {
    mainClass.set("me.whale.backend.WhaleBackendApplicationKt")
}
