plugins {
    id("me.whale.kotlin-rpc-conventions")
    id("me.whale.kotlin-spring-conventions")
}

dependencies {
    runtimeOnly("io.micrometer:micrometer-registry-influx")
}