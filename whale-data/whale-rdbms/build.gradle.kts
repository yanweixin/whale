plugins {
    id("me.whale.kotlin-rpc-conventions")
    id("me.whale.kotlin-spring-conventions")
}

dependencies {
    implementation("me.whale:whale-data-api:0.0.1-SNAPSHOT")
    implementation("me.whale:whale-rpc-proto:0.0.1-SNAPSHOT")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("mysql:mysql-connector-java")
}

springBoot {
    mainClass.set("me.whale.data.dbms.RdbmsApplication")
}