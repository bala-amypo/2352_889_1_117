
package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule) {
        return rule;
    }

    @PutMapping("/{id}")
    public PolicyRule update(@PathVariable Long id,
                             @RequestBody PolicyRule rule) {
        return rule;
    }

    @GetMapping("/active")
    public List<PolicyRule> activeRules() {
        return List.of();
    }

    @GetMapping
    public List<PolicyRule> getAll() {
        return List.of();
    }
}
