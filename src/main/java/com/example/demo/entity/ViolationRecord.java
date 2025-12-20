
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ViolationRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long policyRuleId;
    private Long eventId;
    private String violationType;
    private String details;
    private String severity;
    private LocalDateTime detectedAt;
    private Boolean resolved = false;

    // getters & setters
}
