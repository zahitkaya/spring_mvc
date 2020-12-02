package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/sayHello")
    public Message sayHello() {
        return Message.builder()
                .message("Hello worldd")
                .build();
    }

    @PostMapping("/postHello")
    public String postHello() {
        return "Hello posted";
    }

    @PutMapping("/putHello")
    public String putHello() {
        return "Hello putted";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "Object deleted";
    }
}
