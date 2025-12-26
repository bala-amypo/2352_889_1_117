
package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;
public interface ViolationRecordRepository {
    ViolationRecord save(ViolationRecord v);
    Optional<ViolationRecord> findById(Long id);
    List<ViolationRecord> findByResolvedFalse();
}
