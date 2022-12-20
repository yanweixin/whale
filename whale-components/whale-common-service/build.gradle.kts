plugins {
    id("me.whale.kotlin-rpc-conventions")
}

dependencies {
    implementation("me.whale:whale-rpc-proto:0.0.1-SNAPSHOT")
    implementation(project(":whale-utils:pure-utils"))
}

application {
    mainClass.set("me.whale.components.service.ServerApplication")
}
