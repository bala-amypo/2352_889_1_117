
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody Object request) {
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody Object request) {
        return "User logged in";
    }
}
