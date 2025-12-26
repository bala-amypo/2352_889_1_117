
package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;

public interface UserAccountService {
    UserAccount createUser(UserAccount u);
    UserAccount getUserById(Long id);
    UserAccount updateUserStatus(Long id, String status);
    List<UserAccount> getAllUsers();
}
