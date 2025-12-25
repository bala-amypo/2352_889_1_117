
// UserAccountController.java
package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {
    
    private final UserAccountService service;
    
    public UserAccountController(UserAccountService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<UserAccount> create(@RequestBody UserAccount user) {
        return ResponseEntity.ok(service.createUser(user));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateUserStatus(id, status));
    }
}

// ============================================

// DeviceProfileController.java
package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {
    
    private final DeviceProfileService service;
    
    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }
    
    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        return ResponseEntity.ok(service.findByDeviceId(deviceId).orElse(null));
    }
    
    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestParam Boolean trusted) {
        return ResponseEntity.ok(service.updateTrustStatus(id, trusted));
    }
}

// ============================================

// PolicyRuleController.java
package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PolicyRuleController {
    
    private final PolicyRuleService service;
    
    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<PolicyRule> create(@RequestBody PolicyRule rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }
    
    @GetMapping
    public ResponseEntity<List<PolicyRule>> all() {
        return ResponseEntity.ok(service.getAllRules());
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> active() {
        return ResponseEntity.ok(service.getActiveRules());
    }
}

// ============================================

// ViolationRecordController.java
package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {
    
    private final ViolationRecordService service;
    
    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<ViolationRecord> log(@RequestBody ViolationRecord violation) {
        return ResponseEntity.ok(service.logViolation(violation));
    }
    
    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> unresolved() {
        return ResponseEntity.ok(service.getUnresolvedViolations());
    }
    
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ViolationRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.markResolved(id));
    }
}