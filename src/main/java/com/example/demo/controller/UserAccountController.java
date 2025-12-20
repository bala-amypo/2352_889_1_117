
package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return user;
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id,
                               @RequestParam String status) {
        return "Status updated";
    }

    @GetMapping
    public List<UserAccount> getAll() {
        return List.of();
    }
}
