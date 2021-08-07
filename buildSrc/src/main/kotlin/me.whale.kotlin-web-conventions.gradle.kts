plugins {
    id("me.whale.kotlin-spring-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
    implementation(project(":whale-data:whale-cache"))
}

tasks.bootJar {
    enabled = true
}

tasks.bootRun {
    enabled = true
//    args = listOf("--spring.profiles.active=" + "web")
}