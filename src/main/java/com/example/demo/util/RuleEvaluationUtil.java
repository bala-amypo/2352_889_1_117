
package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class RuleEvaluationUtil {
    
    private final PolicyRuleRepository ruleRepository;
    private final ViolationRecordRepository violationRepository;
    
    public RuleEvaluationUtil(PolicyRuleRepository ruleRepository, 
                              ViolationRecordRepository violationRepository) {
        this.ruleRepository = ruleRepository;
        this.violationRepository = violationRepository;
    }
    
    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepository.findByActiveTrue();
        
        for (PolicyRule rule : activeRules) {
            if (ruleMatches(rule, event)) {
                logViolation(rule, event);
            }
        }
    }
    
    private boolean ruleMatches(PolicyRule rule, LoginEvent event) {
        if (rule.getConditionsJson() == null) {
            return false;
        }
        
        String conditions = rule.getConditionsJson();
        
        // Simple condition matching based on login status
        if (conditions.contains("FAILED") && "FAILED".equals(event.getLoginStatus())) {
            return true;
        }
        
        return false;
    }
    
    private void logViolation(PolicyRule rule, LoginEvent event) {
        ViolationRecord violation = new ViolationRecord();
        violation.setUserId(event.getUserId());
        violation.setEventId(event.getId());
        violation.setSeverity(rule.getSeverity());
        violation.setDetails("Rule violation: " + rule.getRuleCode());
        violation.setResolved(false);
        violation.setCreatedAt(LocalDateTime.now());
        
        violationRepository.save(violation);
    }
}