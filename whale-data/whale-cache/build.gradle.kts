plugins {
    id("me.whale.kotlin-library-conventions")
}

val redissonVersion: String by rootProject.extra
val caffeineVersion: String by rootProject.extra

dependencies {
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
    implementation("me.whale:common-utils:0.0.1-SNAPSHOT")
    implementation("org.redisson:redisson:${redissonVersion}")
    implementation("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
}
