
package com.example.demo.service;

import com.example.demo.repository.UserAccountRepository;

public class UserAccountService {

    private final UserAccountRepository repo;

    // EXACT constructor order (tests require this)
    public UserAccountService(UserAccountRepository repo) {
        this.repo = repo;
    }
}
