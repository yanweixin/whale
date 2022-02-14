plugins {
    id("me.whale.kotlin-library-conventions")
}

val hibernateValidatorVersion: String by rootProject.extra

dependencies {
    api("me.whale:whale-common:0.0.1-SNAPSHOT")
    api("me.whale:pure-utils:0.0.2-SNAPSHOT")
    api("me.whale:common-utils:0.0.1-SNAPSHOT")
    api("org.hibernate.validator:hibernate-validator:${hibernateValidatorVersion}")
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")
}