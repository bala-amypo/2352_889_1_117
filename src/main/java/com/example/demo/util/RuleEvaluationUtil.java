
package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();

        for (PolicyRule rule : activeRules) {
            if (rule.getConditionsJson() != null &&
                event.getLoginStatus() != null &&
                event.getLoginStatus().contains(rule.getConditionsJson())) {

                ViolationRecord v = new ViolationRecord();
                v.setUserId(event.getUserId());
                v.setEventId(event.getId());
                v.setSeverity(rule.getSeverity());
                v.setDetails("Rule " + rule.getRuleCode() + " triggered");
                v.setResolved(false);
                violationRepo.save(v);
            }
        }
    }
}
