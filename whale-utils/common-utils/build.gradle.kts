plugins {
    id("me.whale.kotlin-library-conventions")
}

val commonsLangVersion: String by rootProject.extra
val commonTextVersion: String by rootProject.extra
val guavaVersion by extra("30.1.1-jre")
val poiVersion by extra("5.0.0")
val jacksonVersion: String by rootProject.extra
val snakeYamlVersion by extra("1.29")
val univocityVersion by extra("2.9.1")

dependencies {
    api("org.apache.commons:commons-lang3:${commonsLangVersion}")
    api("com.google.guava:guava:${guavaVersion}")
    implementation("org.apache.commons:commons-text:${commonTextVersion}")
    implementation("org.apache.poi:poi-ooxml:${poiVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-guava:${jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${jacksonVersion}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${jacksonVersion}")
    implementation("org.yaml:snakeyaml:${snakeYamlVersion}")
    implementation("com.univocity:univocity-parsers:${univocityVersion}")
}