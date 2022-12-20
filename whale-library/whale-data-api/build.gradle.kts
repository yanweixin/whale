plugins {
    id("me.whale.kotlin-library-conventions")
}

val hibernateValidatorVersion: String by rootProject.extra

dependencies {
    api(project(":whale-library:whale-common"))
    api(project(":whale-utils:pure-utils"))
    api(project(":whale-utils:common-utils"))
    api("org.hibernate.validator:hibernate-validator:${hibernateValidatorVersion}")
    implementation("jakarta.persistence", "jakarta.persistence-api", "3.1.0")
    testImplementation("org.eclipse.persistence", "eclipselink", "3.0.3") // for jpa test
}