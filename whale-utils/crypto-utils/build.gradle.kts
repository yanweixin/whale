plugins {
    id("me.whale.kotlin-library-conventions")
}

val jwtVersion by extra("0.11.5")

dependencies {
    implementation("commons-codec:commons-codec")
    implementation("io.jsonwebtoken:jjwt-api:${jwtVersion}")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:${jwtVersion}")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:${jwtVersion}")
}