
package com.example.demo.util;

import java.util.*;
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

    public void evaluateLoginEvent(LoginEvent event) {
        for (PolicyRule r : ruleRepo.findByActiveTrue()) {
            if (event.getLoginStatus() != null &&
                event.getLoginStatus().contains(r.getConditionsJson())) {

                ViolationRecord v = new ViolationRecord();
                v.setSeverity(r.getSeverity());
                v.setResolved(false);
                violationRepo.save(v);
            }
        }
    }
}
