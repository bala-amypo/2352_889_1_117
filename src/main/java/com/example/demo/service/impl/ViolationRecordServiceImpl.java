
// package com.example.demo.service.impl;

// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.repository.ViolationRecordRepository;
// import com.example.demo.service.ViolationRecordService;
// import org.springframework.stereotype.Service;
// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class ViolationRecordServiceImpl implements ViolationRecordService {
//     private final ViolationRecordRepository violationRepo;
    
//     public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
//         this.violationRepo = violationRepo;
//     }
    
//     @Override
//     public ViolationRecord logViolation(ViolationRecord violation) {
//         violation.setDetectedAt(LocalDateTime.now());
//         if (violation.getResolved() == null) {
//             violation.setResolved(false);
//         }
//         return violationRepo.save(violation);
//     }
    
//     @Override
//     public List<ViolationRecord> getViolationsByUser(Long userId) {
//         return violationRepo.findByUserId(userId);
//     }
    
//     @Override
//     public ViolationRecord markResolved(Long id) {
//         ViolationRecord violation = violationRepo.findById(id).orElseThrow(() -> 
//             new RuntimeException("Violation not found"));
//         violation.setResolved(true);
//         return violationRepo.save(violation);
//     }
    
//     @Override
//     public List<ViolationRecord> getUnresolvedViolations() {
//         return violationRepo.findByResolvedFalse();
//     }
    
//     @Override
//     public List<ViolationRecord> getAllViolations() {
//         return violationRepo.findAll();
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;

public class ViolationRecordServiceImpl implements ViolationRecordService {
    private final ViolationRecordRepository repo;
    public ViolationRecordServiceImpl(ViolationRecordRepository repo) { this.repo = repo; }

    public ViolationRecord logViolation(ViolationRecord v) { return repo.save(v); }
    public List<ViolationRecord> getUnresolvedViolations() { return repo.findByResolvedFalse(); }
    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = repo.findById(id).orElse(null);
        v.setResolved(true);
        return repo.save(v);
    }
}
