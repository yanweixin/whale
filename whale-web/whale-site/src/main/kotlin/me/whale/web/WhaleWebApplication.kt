package me.whale.web

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WhaleWebApplication

fun main(args: Array<String>) {
    runApplication<WhaleWebApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
