
package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.*;
public interface ViolationRecordService {
    ViolationRecord logViolation(ViolationRecord v);
    List<ViolationRecord> getUnresolvedViolations();
    ViolationRecord markResolved(Long id);
}
