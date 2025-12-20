
package com.example.demo.service;

import com.example.demo.repository.LoginEventRepository;
import com.example.demo.util.RuleEvaluationUtil;

public class LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil util;

    public LoginEventService(LoginEventRepository repo,
                             RuleEvaluationUtil util) {
        this.repo = repo;
        this.util = util;
    }
}
