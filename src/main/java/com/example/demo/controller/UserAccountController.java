
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/users")
@Tag(name = "User Account Controller")
public class UserAccountController {

    @PostMapping
    public String createUser(@RequestBody Object user) {
        return "User created";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        return "User with ID " + id;
    }

    @PutMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id) {
        return "User status updated for ID " + id;
    }

    @GetMapping
    public String getAllUsers() {
        return "All users list";
    }
}
