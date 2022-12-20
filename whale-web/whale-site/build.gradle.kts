plugins {
    id("me.whale.kotlin-web-conventions")
    id("me.whale.kotlin-rpc-conventions")
}

dependencies {
    implementation(project(":whale-library:whale-data-api"))
    implementation("me.whale:whale-rpc-proto:0.0.1-SNAPSHOT")
    implementation(project(":whale-utils:pure-utils"))
    implementation(project(":whale-library:whale-cache"))
    implementation(project(":whale-library:whale-web-starter"))
}

springBoot {
    mainClass.set("me.whale.web.WhaleWebApplicationKt")
}

tasks.bootRun {
    args = listOf("--spring.profiles.active=" + "site")
}
