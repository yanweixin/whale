plugins {
    id("me.whale.kotlin-web-conventions")
}

springBoot {
    mainClass.set("me.whale.web.WhaleWebApplicationKt")
}

tasks.bootRun {
    args = listOf("--spring.profiles.active=" + "site")
}
