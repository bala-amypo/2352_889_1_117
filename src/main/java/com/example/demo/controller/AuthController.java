
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController() {
        this.jwtUtil = new JwtUtil("secret-key", 3600000L, true);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return new JwtResponse(token);
    }

    @PostMapping("/register")
    public String register() {
        return "Registered successfully";
    }
}
