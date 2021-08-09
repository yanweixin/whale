package me.whale.web.controller

import me.whale.web.service.CommonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/whale/web/site")
class HomeController(private val commonService: CommonService) {

    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): ResponseEntity<String> {
        return ResponseEntity.ok(commonService.hello(name))
    }
}