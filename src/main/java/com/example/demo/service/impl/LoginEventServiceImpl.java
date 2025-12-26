package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class LoginEventServiceImpl implements LoginEventService {
    private final LoginEventRepository repo;
    private final Object evaluator;

    public LoginEventServiceImpl(LoginEventRepository repo, Object evaluator) {
        this.repo = repo;
        this.evaluator = evaluator;
    }
    public LoginEvent recordLogin(LoginEvent e) { return repo.save(e); }
    public List<LoginEvent> getEventsByUser(Long id) { return repo.findByUserId(id); }
    public List<LoginEvent> getSuspiciousLogins(Long id) {
        return repo.findByUserIdAndLoginStatus(id, "FAILED");
    }
}
