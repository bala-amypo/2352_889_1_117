

package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

@RestController
@RequestMapping("/api/violations")
@Tag(name = "violation-record-controller")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord violation) {
        return violation;
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
    public List<ViolationRecord> all() {
        return List.of();
    }
}
