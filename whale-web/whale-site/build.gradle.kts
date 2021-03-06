plugins {
    id("me.whale.kotlin-web-conventions")
    id("me.whale.kotlin-rpc-conventions")
}

dependencies {
    implementation("me.whale:whale-data-api:0.0.1-SNAPSHOT")
    implementation("me.whale:whale-rpc-proto:0.0.1-SNAPSHOT")
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
    implementation("me.whale:whale-cache:0.0.1-SNAPSHOT")
    implementation("me.whale:whale-web-starter:0.0.1-SNAPSHOT")
}

springBoot {
    mainClass.set("me.whale.web.WhaleWebApplicationKt")
}

tasks.bootRun {
    args = listOf("--spring.profiles.active=" + "site")
}
