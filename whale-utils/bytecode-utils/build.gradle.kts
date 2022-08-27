plugins {
    id("me.whale.kotlin-library-conventions")
}
val aspectjVersion by extra("1.9.9.1")
val asmVersion by extra("9.3")
val javassistVersion by extra("3.29.1-GA")

dependencies {
    implementation("org.aspectj:aspectjrt:${aspectjVersion}")
    implementation("org.aspectj:aspectjweaver:${aspectjVersion}")
    implementation("org.ow2.asm:asm:${asmVersion}")
    implementation("org.javassist:javassist:${javassistVersion}")
}
