plugins {
    id("me.whale.kotlin-library-conventions")
}

val redissonVersion by extra("3.16.1")
val caffeineVersion by extra("3.0.3")

dependencies {
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
    implementation("me.whale:common-utils:0.0.1-SNAPSHOT")
    implementation("org.redisson:redisson:${redissonVersion}")
    implementation("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
}
