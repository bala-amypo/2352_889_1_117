
package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RuleEvaluationUtil {

    private final PolicyRuleRepository policyRuleRepository;
    private final ViolationRecordRepository violationRecordRepository;

    public RuleEvaluationUtil(PolicyRuleRepository policyRuleRepository,
                              ViolationRecordRepository violationRecordRepository) {
        this.policyRuleRepository = policyRuleRepository;
        this.violationRecordRepository = violationRecordRepository;
    }

    public void evaluateLoginEvent(LoginEvent event) {
        List<PolicyRule> rules = policyRuleRepository.findByActiveTrue();

        for (PolicyRule rule : rules) {
            ViolationRecord record = new ViolationRecord();
            record.setUserId(event.getUserId());
            record.setEventId(event.getId());
            record.setPolicyRuleId(rule.getId());
            record.setViolationType(rule.getRuleCode());
            record.setSeverity(rule.getSeverity());
            record.setDetails("Rule violated");
            record.setDetectedAt(LocalDateTime.now());
            record.setResolved(false);
            violationRecordRepository.save(record);
        }
    }
}
