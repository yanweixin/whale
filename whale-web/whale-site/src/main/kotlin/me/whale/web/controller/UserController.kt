package me.whale.web.controller

import me.whale.web.service.UserService
import me.whale.web.view.UserVo
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import jakarta.validation.Valid

@RestController
@RequestMapping("whale/web/site/user")
class UserController(private val userService: UserService) {
    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @PostMapping("add")
    fun add(@Valid user: UserVo): ResponseEntity<Any> {
        return userService.add(user)
    }

}