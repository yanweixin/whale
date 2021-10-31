plugins {
    id("me.whale.kotlin-rpc-conventions")
}

dependencies {
    implementation("me.whale:whale-components-api:0.0.1-SNAPSHOT")
    implementation("me.whale:pure-utils:0.0.2-SNAPSHOT")
}

application {
    mainClass.set("me.whale.components.service.ServerApplication")
}
