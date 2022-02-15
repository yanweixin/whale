package me.whale.web.controller

import jakarta.validation.Valid
import me.whale.web.service.CommonService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import jakarta.validation.constraints.Size
import me.whale.web.view.LoginVo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("whale/web/site")
@Validated
class HomeController(private val commonService: CommonService) {

    @GetMapping("hello")
    fun hello(@Size(min = 10) @RequestParam("name") name: String): ResponseEntity<String> {
        return ResponseEntity.ok(commonService.hello(name))
    }

    @PostMapping("login")
    fun login(@Valid loginVo: LoginVo): ResponseEntity<String> {
        return ResponseEntity.ok("login success")
    }
}