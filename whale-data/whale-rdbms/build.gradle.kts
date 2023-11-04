plugins {
    id("me.whale.kotlin-rpc-conventions")
    id("me.whale.kotlin-spring-conventions")
}

dependencies {
    implementation(project(":whale-library:whale-data-api"))
    implementation("me.whale:whale-rpc-proto:${project.version}")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("com.mysql:mysql-connector-j")
}

springBoot {
    mainClass.set("me.whale.data.dbms.RdbmsApplication")
}