
package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController() {
        this.service = new UserAccountService(null);
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return user;
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return List.of();
    }
}
