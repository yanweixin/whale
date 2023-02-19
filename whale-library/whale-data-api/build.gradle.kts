plugins {
    id("me.whale.kotlin-library-conventions")
}

val hibernateValidatorVersion: String by rootProject.extra

dependencies {
    api(project(":whale-library:whale-common"))
    api(project(":whale-utils:pure-utils"))
    api(project(":whale-utils:common-utils"))
    api("org.hibernate.validator:hibernate-validator")
    implementation("jakarta.persistence", "jakarta.persistence-api")
    testImplementation("org.eclipse.persistence", "eclipselink", "4.0.0") // for jpa test
}