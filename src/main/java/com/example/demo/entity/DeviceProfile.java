
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeviceProfile {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @Column(unique = true)
    private String deviceId;

    private String deviceType;
    private String osVersion;
    private LocalDateTime lastSeen = LocalDateTime.now();
    private Boolean isTrusted;

    // getters & setters
}
