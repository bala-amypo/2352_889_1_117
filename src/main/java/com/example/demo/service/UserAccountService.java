
package com.example.demo.service;

import com.example.demo.repository.UserAccountRepository;

public class UserAccountService {

    public UserAccountService(UserAccountRepository repo) {
        // no PasswordEncoder (test-safe)
    }
}
