
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAccountService userService;

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        return userService.register(username, password);
    }
}
