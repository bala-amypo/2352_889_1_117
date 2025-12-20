
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/api/users")
@Tag(name = "user-account-controller")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccount create(@RequestBody UserAccount user) {
        return user;
    }

    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return new UserAccount();
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
