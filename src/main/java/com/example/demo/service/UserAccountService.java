
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    // used by AuthController
    UserAccount register(String username, String password);

    // used by UserAccountController
    UserAccount createUser(UserAccount user);

    UserAccount getUserById(Long id);

    List<UserAccount> getAllUsers();

    UserAccount updateUserStatus(Long id, String status);
}
