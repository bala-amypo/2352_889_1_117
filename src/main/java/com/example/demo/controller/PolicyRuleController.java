
package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
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
    public PolicyRule update(@PathVariable Long id, @RequestBody PolicyRule rule) {
        return rule;
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
