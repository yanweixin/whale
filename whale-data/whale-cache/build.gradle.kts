plugins {
    id("me.whale.kotlin-spring-conventions")
    id("me.whale.kotlin-library-conventions")
}

val redissonVersion by extra("3.16.0")
val caffeineVersion by extra("3.0.3")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.redisson:redisson-spring-boot-starter:${redissonVersion}")
    implementation("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
}
