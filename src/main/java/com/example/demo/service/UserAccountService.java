
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    // Create a new user
    UserAccount createUser(UserAccount user);

    // Get user by ID
    UserAccount getUserById(Long id);

    // Get all users
    List<UserAccount> getAllUsers();

    // Update user status (ACTIVE / SUSPENDED)
    UserAccount updateUserStatus(Long id, String status);
}
