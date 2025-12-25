
package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount u) {
        return ResponseEntity.ok(userService.createUser(u));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAccount>> all() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
