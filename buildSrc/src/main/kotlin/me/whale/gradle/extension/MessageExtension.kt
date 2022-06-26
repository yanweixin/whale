package me.whale.gradle.extension

import org.gradle.api.provider.Property

public abstract class MessageExtension {
    abstract val message: Property<String>
    abstract val greeter: Property<String>

    init {
        message.convention("Hello")
        greeter.convention("WhalePlugin")
    }
}