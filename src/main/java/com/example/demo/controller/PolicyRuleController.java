
package com.example.demo.controller;

import org.springframework.http.*;
import java.util.*;
import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;

public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
}
