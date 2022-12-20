plugins {
    id("me.whale.kotlin-library-conventions")
}

val redissonVersion: String by rootProject.extra
val caffeineVersion: String by rootProject.extra

dependencies {
    implementation(project(":whale-utils:pure-utils"))
    implementation(project(":whale-utils:common-utils"))
    implementation("org.redisson:redisson:${redissonVersion}")
    implementation("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
}
