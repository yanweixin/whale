package me.whale.backend

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class WhaleBackendApplication

fun main(args: Array<String>) {
    runApplication<WhaleBackendApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}