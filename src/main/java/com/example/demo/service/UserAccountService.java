
package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    String register(String username, String password);
}


public interface UserAccountService {
    UserAccount createUser(UserAccount u);
    UserAccount getUserById(Long id);
    UserAccount updateUserStatus(Long id, String status);
    List<UserAccount> getAllUsers();
}
