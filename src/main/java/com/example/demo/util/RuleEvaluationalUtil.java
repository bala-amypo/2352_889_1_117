
package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository policyRepo,
                              ViolationRecordRepository violationRepo) {
        this.policyRepo = policyRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = policyRepo.findByActiveTrue();

        for (PolicyRule rule : rules) {
            if ("FAILED".equals(event.getLoginStatus())) {
                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setPolicyRuleId(rule.getId());
                v.setEventId(event.getId());
                v.setViolationType("LOGIN_FAILURE");
                v.setSeverity(rule.getSeverity());
                v.setDetails("Policy triggered: " + rule.getRuleCode());
                violationRepo.save(v);
            }
        }
    }
}
