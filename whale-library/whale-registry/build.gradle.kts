plugins {
    id("me.whale.kotlin-library-conventions")
}

val curatorVersion: String by rootProject.extra

dependencies {
    implementation("org.apache.curator:curator-recipes:${curatorVersion}")
}
