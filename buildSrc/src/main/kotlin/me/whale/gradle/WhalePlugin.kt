package me.whale.gradle

import gradle.kotlin.dsl.accessors._04bf94890066869138e15fc86d43a456.implementationDependenciesMetadata
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

