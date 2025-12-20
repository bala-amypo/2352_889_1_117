
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.util.RuleEvaluationUtil;

public class LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil util;

    // EXACT constructor order (MANDATORY)
    public LoginEventService(LoginEventRepository repo,
                             RuleEvaluationUtil util) {
        this.repo = repo;
        this.util = util;
    }

    // Controller calls this
    public LoginEvent record(LoginEvent event) {
        LoginEvent saved = repo.save(event);
        util.evaluateLoginEvent(saved);
        return saved;
    }

    // Controller calls this
    public List<LoginEvent> suspicious(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    public List<LoginEvent> all() {
        return repo.findAll();
    }
}
