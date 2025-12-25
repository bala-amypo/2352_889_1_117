
package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    // for AuthController
    @Override
    public UserAccount register(String username, String password) {
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus("ACTIVE");
        return repo.save(user);
    }

    // for UserAccountController
    @Override
    public UserAccount createUser(UserAccount user) {
        return repo.save(user);
    }

    @Override
    public UserAccount getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public UserAccount updateUserStatus(Long id, String status) {
        UserAccount user = repo.findById(id).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return repo.save(user);
        }
        return null;
    }
}
