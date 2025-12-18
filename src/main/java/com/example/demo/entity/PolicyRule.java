
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;
    private String severity;
    private Boolean active = true;

    public Long getId() { return id; }
    public String getRuleCode() { return ruleCode; }
    public String getSeverity() { return severity; }
}
