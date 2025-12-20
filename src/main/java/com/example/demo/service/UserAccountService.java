
package com.example.demo.service;

import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAccountService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;

    public UserAccountService(UserAccountRepository repo,
                              PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }
}
