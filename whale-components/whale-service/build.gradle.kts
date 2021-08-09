plugins {
    id("me.whale.kotlin-rpc-conventions")
}

dependencies {
    implementation("me.whale:whale-rpc:0.0.1-SNAPSHOT")
    implementation("me.whale:whale-components-api:0.0.1-SNAPSHOT")
}

application {
    mainClass.set("me.whale.components.service.ServerApplication")
}

tasks.register("bootRun") {
    dependsOn("run")
    doLast {
        println("${project.name} started running")
    }
}