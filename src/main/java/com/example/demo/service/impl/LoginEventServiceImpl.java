


// LoginEventServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {
    
    private final LoginEventRepository repository;
    private final RuleEvaluationUtil ruleEvaluator;
    
    public LoginEventServiceImpl(LoginEventRepository repository, RuleEvaluationUtil ruleEvaluator) {
        this.repository = repository;
        this.ruleEvaluator = ruleEvaluator;
    }
    
    @Override
    public LoginEvent recordLogin(LoginEvent event) {
        LoginEvent saved = repository.save(event);
        ruleEvaluator.evaluateLoginEvent(saved);
        return saved;
    }
    
    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return repository.findByUserId(userId);
    }
    
    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repository.findByUserIdAndLoginStatus(userId, "FAILED");
    }
}



