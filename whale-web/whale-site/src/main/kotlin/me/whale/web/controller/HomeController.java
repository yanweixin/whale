package me.whale.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whale/web/site")
public class HomeController {

    @RequestMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("hello world");
    }

}
