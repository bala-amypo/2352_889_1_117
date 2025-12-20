
package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController() {
        this.service = new ViolationRecordService(null);
    }

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord record) {
        return record;
    }

    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return List.of();
    }

    @PutMapping("/{id}/resolve")
    public void resolve(@PathVariable Long id) {
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return List.of();
    }

    @GetMapping
    public List<ViolationRecord> all() {
        return List.of();
    }
}
