plugins {
    id("me.whale.kotlin-library-conventions")
}

val commonTextVersion: String by rootProject.extra
val poiVersion: String by rootProject.extra
val easyexcelVersion:String by rootProject.extra
val univocityVersion: String by rootProject.extra

dependencies {
    api("org.apache.commons:commons-lang3")
    implementation("org.apache.commons:commons-text:${commonTextVersion}")
    implementation("org.apache.poi:poi-ooxml:${poiVersion}")
    implementation("com.alibaba:easyexcel:${easyexcelVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-guava")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.yaml:snakeyaml")
    implementation("com.univocity:univocity-parsers:${univocityVersion}")
}