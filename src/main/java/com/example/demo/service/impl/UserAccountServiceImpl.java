
package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository repo;
    public UserAccountServiceImpl(UserAccountRepository repo, Object encoder) {
        this.repo = repo;
    }
    public UserAccount createUser(UserAccount u) { return repo.save(u); }
    public UserAccount getUserById(Long id) { return repo.findById(id).orElse(null); }
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount u = repo.findById(id).orElse(null);
        u.setStatus(status);
        return repo.save(u);
    }
    public List<UserAccount> getAllUsers() { return repo.findAll(); }
}
