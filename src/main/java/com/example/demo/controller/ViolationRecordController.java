
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/violations")
@Tag(name = "Violation Record Controller")
public class ViolationRecordController {

    @PostMapping
    public String logViolation(@RequestBody Object violation) {
        return "Violation logged";
    }

    @GetMapping("/user/{userId}")
    public String getViolationsByUser(@PathVariable Long userId) {
        return "Violations for user " + userId;
    }

    @PutMapping("/{id}/resolve")
    public String resolveViolation(@PathVariable Long id) {
        return "Violation resolved for ID " + id;
    }

    @GetMapping("/unresolved")
    public String getUnresolvedViolations() {
        return "Unresolved violations";
    }

    @GetMapping
    public String getAllViolations() {
        return "All violations";
    }
}
