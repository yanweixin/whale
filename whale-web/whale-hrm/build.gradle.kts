import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("me.whale.kotlin-rpc-conventions")
}

val vertxVersion: String by rootProject.extra

val mainVerticleName = "me.whale.hrm.MainVerticle"
val launcherClassName = "io.vertx.core.Launcher"

val watchForChange = "src/**/*"
val doOnChange = "${projectDir}/gradlew classes"

application {
    mainClass.set(launcherClassName)
}

dependencies {
    implementation(platform("io.vertx:vertx-stack-depchain:$vertxVersion"))
    implementation("io.vertx:vertx-web-client")
    implementation("io.vertx:vertx-web")
    implementation("io.vertx:vertx-lang-kotlin")
    runtimeOnly("io.netty", "netty-resolver-dns-native-macos", null, null, "osx-x86_64")
    testImplementation("io.vertx:vertx-junit5")
}

tasks.withType<ShadowJar> {
    enabled = true
    archiveClassifier.set("fat")
    manifest {
        attributes(mapOf("Main-Verticle" to mainVerticleName))
    }
    mergeServiceFiles()
}

tasks.withType<JavaExec> {
    args = listOf(
        "run",
        mainVerticleName,
        "--redeploy=$watchForChange",
        "--launcher-class=$launcherClassName",
        "--on-redeploy=$doOnChange"
    )
}