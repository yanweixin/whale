plugins {
    id("me.whale.kotlin-web-conventions")
}

dependencies {
    implementation(project(":whale-library:whale-data-api"))
    implementation(project(":whale-library:whale-cache"))
    implementation(project(":whale-library:whale-web-starter"))
}

springBoot {
    mainClass.set("me.whale.backend.WhaleBackendApplicationKt")
}
