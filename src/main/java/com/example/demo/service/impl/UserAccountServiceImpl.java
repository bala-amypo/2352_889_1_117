
package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.UserAccountService;

@Service   // 🔥 THIS IS MANDATORY
public class UserAccountServiceImpl implements UserAccountService {

    @Override
    public String register(String username, String password) {
        return "User Registered: " + username;
    }
}
