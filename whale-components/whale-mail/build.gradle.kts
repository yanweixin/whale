plugins {
    id("me.whale.kotlin-rpc-conventions")
}

val springVersion: String by rootProject.extra

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-mail:${springVersion}")
}
