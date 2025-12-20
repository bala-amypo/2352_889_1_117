
package com.example.demo.controller;

import com.example.demo.dto.JwtRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController() {
        // Manual instantiation (as required by problem statement)
        this.jwtUtil = new JwtUtil("test-secret", 3600000L, true);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody JwtRequest request) {
        String token = jwtUtil.generateToken(request.getUsername());
        return new JwtResponse(token);
    }

    @PostMapping("/register")
    public String register() {
        return "User Registered";
    }
}
