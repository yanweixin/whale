package me.whale.gradle

import me.whale.gradle.extension.MessageExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class WhalePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create<MessageExtension>("greeter")
        println(extension.message.get() + "from" + extension.greeter.get())
    }
}

