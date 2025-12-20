
package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.PolicyRuleRepository;

@Service
public class PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleService(PolicyRuleRepository repo) {
        this.repo = repo;
    }
}
