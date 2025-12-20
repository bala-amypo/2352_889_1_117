

package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.UserAccountRepository;

@Service
public class UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountService(UserAccountRepository repo) {
        this.repo = repo;
    }
}
