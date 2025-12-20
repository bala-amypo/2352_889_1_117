
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Policy Rule Controller")
public class PolicyRuleController {

    @PostMapping
    public String createRule(@RequestBody Object rule) {
        return "Rule created";
    }

    @PutMapping("/{id}")
    public String updateRule(@PathVariable Long id) {
        return "Rule updated with ID " + id;
    }

    @GetMapping("/active")
    public String getActiveRules() {
        return "Active rules";
    }

    @GetMapping
    public String getAllRules() {
        return "All rules";
    }
}
