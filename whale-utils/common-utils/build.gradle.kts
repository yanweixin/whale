plugins {
    id("me.whale.kotlin-library-conventions")
}

val commonsLangVersion: String by rootProject.extra
val commonTextVersion: String by rootProject.extra
val poiVersion: String by rootProject.extra
val easyexcelVersion:String by rootProject.extra
val jacksonVersion: String by rootProject.extra
val snakeYamlVersion: String by rootProject.extra
val univocityVersion: String by rootProject.extra

dependencies {
    api("org.apache.commons:commons-lang3:${commonsLangVersion}")
    implementation("org.apache.commons:commons-text:${commonTextVersion}")
    implementation("org.apache.poi:poi-ooxml:${poiVersion}")
    implementation("com.alibaba:easyexcel:${easyexcelVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-guava:${jacksonVersion}")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${jacksonVersion}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${jacksonVersion}")
    implementation("org.yaml:snakeyaml:${snakeYamlVersion}")
    implementation("com.univocity:univocity-parsers:${univocityVersion}")
}