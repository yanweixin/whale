package me.whale.web.controller

import me.whale.data.api.view.UserVo
import me.whale.web.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/whale/web/site/user")
class UserController(private val userService: UserService) {

    @PostMapping("add")
    fun add(@Valid user: UserVo): ResponseEntity<Any> {
        return userService.add(user)
    }

}