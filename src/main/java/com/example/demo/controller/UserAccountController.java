package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService userService;

    public UserAccountController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(userService.updateUserStatus(id, status));
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}

// package com.example.demo.controller;

// import com.example.demo.entity.*;
// import com.example.demo.service.*;
// import org.springframework.http.*;

// public class UserAccountController {
//     private final UserAccountService service;
//     public UserAccountController(UserAccountService service) {
//         this.service = service;
//     }
//     public ResponseEntity<UserAccount> create(UserAccount u) {
//         return ResponseEntity.ok(service.createUser(u));
//     }
// }