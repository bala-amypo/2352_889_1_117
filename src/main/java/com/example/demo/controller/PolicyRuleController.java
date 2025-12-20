
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "policy-rule-controller")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule) {
        return rule;
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id,
                         @RequestBody PolicyRule rule) {
        return "Rule updated";
    }

    @GetMapping("/active")
    public List<PolicyRule> active() {
        return List.of();
    }

    @GetMapping
    public List<PolicyRule> all() {
        return List.of();
    }
}
