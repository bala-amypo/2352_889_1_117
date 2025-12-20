
package com.example.demo.service;

import com.example.demo.repository.PolicyRuleRepository;

public class PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleService(PolicyRuleRepository repo) {
        this.repo = repo;
    }
}
