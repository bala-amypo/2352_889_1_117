
package com.example.demo.controller;

import org.springframework.http.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    public ResponseEntity<UserAccount> create(UserAccount u) {
        return ResponseEntity.ok(service.createUser(u));
    }
}
