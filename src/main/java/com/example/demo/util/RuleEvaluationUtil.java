
// package com.example.demo.util;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.entity.PolicyRule;
// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.repository.ViolationRecordRepository;
// import org.springframework.stereotype.Component;
// import java.util.List;

// @Component
// public class RuleEvaluationUtil {
//     private final PolicyRuleRepository ruleRepo;
//     private final ViolationRecordRepository violationRepo;
    
//     public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
//         this.ruleRepo = ruleRepo;
//         this.violationRepo = violationRepo;
//     }
    
//     public void evaluateLoginEvent(LoginEvent event) {
//         List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();
        
//         for (PolicyRule rule : activeRules) {
//             if (isViolation(event, rule)) {
//                 ViolationRecord violation = new ViolationRecord();
//                 violation.setUserId(event.getUserId());
//                 violation.setPolicyRuleId(rule.getId());
//                 violation.setEventId(event.getId());
//                 violation.setViolationType("LOGIN_VIOLATION");
//                 violation.setDetails("Rule violation detected");
//                 violation.setSeverity(rule.getSeverity());
//                 violationRepo.save(violation);
//             }
//         }
//     }
    
//     private boolean isViolation(LoginEvent event, PolicyRule rule) {
//         String conditions = rule.getConditionsJson();
//         if (conditions != null && conditions.contains("FAILED")) {
//             return "FAILED".equals(event.getLoginStatus());
//         }
//         return false;
//     }
// }

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
