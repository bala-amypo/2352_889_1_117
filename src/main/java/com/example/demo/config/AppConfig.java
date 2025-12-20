
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.util.RuleEvaluationUtil;

@Configuration
public class AppConfig {

    @Bean
    public RuleEvaluationUtil ruleEvaluationUtil(
            PolicyRuleRepository policyRuleRepository,
            ViolationRecordRepository violationRecordRepository) {

        return new RuleEvaluationUtil(
                policyRuleRepository,
                violationRecordRepository
        );
    }
}
