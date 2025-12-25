
package com.example.demo.controller;

import org.springframework.http.*;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    public ResponseEntity<ViolationRecord> log(ViolationRecord v) {
        return ResponseEntity.ok(service.logViolation(v));
    }
}
