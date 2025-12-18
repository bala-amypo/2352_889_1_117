
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long policyRuleId;
    private Long eventId;
    private String violationType;
    private String details;
    private String severity;
    private Boolean resolved = false;
    private LocalDateTime detectedAt = LocalDateTime.now();

    public void setUserId(Long userId) { this.userId = userId; }
    public void setPolicyRuleId(Long policyRuleId) { this.policyRuleId = policyRuleId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }
    public void setViolationType(String violationType) { this.violationType = violationType; }
    public void setDetails(String details) { this.details = details; }
    public void setSeverity(String severity) { this.severity = severity; }
}
