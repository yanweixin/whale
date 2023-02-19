plugins {
    id("me.whale.kotlin-library-conventions")
}
val asmVersion by extra("9.4")
val javassistVersion by extra("3.29.2-GA")

dependencies {
    implementation("org.aspectj:aspectjrt")
    implementation("org.aspectj:aspectjweaver")
    implementation("org.ow2.asm:asm:${asmVersion}")
    implementation("org.javassist:javassist:${javassistVersion}")
}
