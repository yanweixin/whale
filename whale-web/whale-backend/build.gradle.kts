plugins {
    id("me.whale.kotlin-web-conventions")
}

dependencies {
    implementation("me.whale:whale-data-api:0.0.1-SNAPSHOT")
    implementation("me.whale:whale-cache:0.0.1-SNAPSHOT")
}

springBoot {
    mainClass.set("me.whale.backend.WhaleBackendApplicationKt")
}
