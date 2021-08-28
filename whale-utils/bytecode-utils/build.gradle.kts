plugins {
    id("me.whale.kotlin-library-conventions")
}
val aspectjVersion by extra("1.9.7")
val asmVersion by extra("9.2")
val javassistVersion by extra("3.28.0-GA")

dependencies {
    implementation("org.aspectj:aspectjrt:${aspectjVersion}")
    implementation("org.aspectj:aspectjweaver:${aspectjVersion}")
    implementation("org.ow2.asm:asm:${asmVersion}")
    implementation("org.javassist:javassist:${javassistVersion}")
}
