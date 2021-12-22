package me.whale.web.controller

import me.whale.web.service.CommonService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Size

@RestController
@RequestMapping("whale/web/site")
@Validated
class HomeController(private val commonService: CommonService) {

    @GetMapping("hello")
    fun hello(@Size(min = 10) @RequestParam("name") name: String): ResponseEntity<String> {
        return ResponseEntity.ok(commonService.hello(name))
    }
}