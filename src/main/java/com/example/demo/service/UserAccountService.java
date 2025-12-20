
package com.example.demo.service;

import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAccountService {

    public UserAccountService(UserAccountRepository repo, PasswordEncoder encoder) {
    }
}
