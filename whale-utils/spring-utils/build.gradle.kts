plugins {
    id("me.whale.kotlin-library-conventions")
}

val springVersion by extra("2.5.2")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-mail:${springVersion}")
}
