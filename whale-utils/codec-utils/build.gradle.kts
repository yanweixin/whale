plugins {
    id("me.whale.kotlin-library-conventions")
}

val commonsCodecVersion by extra("1.15")
val jwtVersion by extra("0.11.2")

dependencies {
    implementation("commons-codec:commons-codec:${commonsCodecVersion}")
    implementation("io.jsonwebtoken:jjwt-api:${jwtVersion}")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:${jwtVersion}")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:${jwtVersion}")
}