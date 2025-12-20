
package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord record) {
        return record;
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return List.of();
    }

    @PutMapping("/{id}/resolve")
    public String resolve(@PathVariable Long id) {
        return "Resolved";
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return List.of();
    }

    @GetMapping
    public List<ViolationRecord> getAll() {
        return List.of();
    }
}
