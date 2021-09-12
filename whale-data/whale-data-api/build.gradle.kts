plugins {
    id("me.whale.kotlin-library-conventions")
}

dependencies {
    api("me.whale:whale-common:0.0.1-SNAPSHOT")
    api("me.whale:pure-utils:0.0.2-SNAPSHOT")
    api("me.whale:common-utils:0.0.1-SNAPSHOT")
    implementation("jakarta.persistence:jakarta.persistence-api:2.2.3")
}