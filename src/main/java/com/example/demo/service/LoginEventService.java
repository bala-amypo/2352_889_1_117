
package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ⭐ VERY IMPORTANT
public class LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil util;

    public LoginEventService(LoginEventRepository repo,
                             RuleEvaluationUtil util) {
        this.repo = repo;
        this.util = util;
    }

    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = repo.save(event);
        util.evaluateLoginEvent(saved);
        return saved;
    }

    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
    }
}
