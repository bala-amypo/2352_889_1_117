
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserAccountService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    
    public AuthController(UserAccountService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setEmployeeId(request.getEmployeeId());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        return ResponseEntity.ok(userService.createUser(user));
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        UserAccount user = userService.findByUsername(request.getUsernameOrEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername(), user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.ok(new JwtResponse(token, user.getId(), user.getEmail(), user.getRole()));
        }
        throw new RuntimeException("Invalid credentials");
    }
}