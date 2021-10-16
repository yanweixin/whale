plugins {
    id("me.whale.kotlin-library-conventions")
}

val amqpVersion: String by rootProject.extra
val kafkaVersion: String by rootProject.extra

dependencies {
    implementation("com.rabbitmq:amqp-client:${amqpVersion}")
    implementation("org.apache.kafka:kafka-clients:${kafkaVersion}")
}
