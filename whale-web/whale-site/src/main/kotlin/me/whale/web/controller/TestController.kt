package me.whale.web.controller

import me.whale.data.api.validator.annotation.ValidEmail
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("whale/web/site/test")
@Validated
class TestController {
    private val logger = LoggerFactory.getLogger(TestController::class.java)

    @RequestMapping("valid")
    fun test(@ValidEmail email: String): ResponseEntity<Any> {
        return ResponseEntity.ok("1")
    }
}