
package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class RuleEvaluationUtil {
    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent e) {
        for (PolicyRule r : ruleRepo.findByActiveTrue()) {
            if (r.getConditionsJson() != null &&
                e.getLoginStatus() != null &&
                r.getConditionsJson().contains(e.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setSeverity(r.getSeverity());
                violationRepo.save(v);
            }
        }
    }
}
