
package com.example.demo.service;

import com.example.demo.repository.ViolationRecordRepository;

public class ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordService(ViolationRecordRepository repo) {
        this.repo = repo;
    }
}
