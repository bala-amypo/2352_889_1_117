
package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    public void evaluate(LoginEvent event) {
        if ("FAILED".equals(event.getLoginStatus())) {
            System.out.println("⚠️ Failed login detected for user: " + event.getUserId());
        }
    }
}
