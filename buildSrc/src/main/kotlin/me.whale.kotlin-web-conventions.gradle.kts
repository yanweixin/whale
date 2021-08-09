plugins {
    id("me.whale.kotlin-spring-conventions")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
}

tasks.bootJar {
    enabled = true
}

tasks.bootRun {
    enabled = true
//    args = listOf("--spring.profiles.active=" + "web")
}