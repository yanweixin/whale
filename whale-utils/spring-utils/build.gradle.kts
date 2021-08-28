plugins {
    id("me.whale.kotlin-library-conventions")
}

val springVersion: String by rootProject.extra

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-mail:${springVersion}")
}
