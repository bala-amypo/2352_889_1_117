
package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.ViolationRecordRepository;

@Service
public class ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordService(ViolationRecordRepository repo) {
        this.repo = repo;
    }
}
