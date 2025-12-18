
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String ipAddress;
    private String location;
    private String deviceId;
    private String loginStatus;
    private LocalDateTime timestamp = LocalDateTime.now();

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getLoginStatus() { return loginStatus; }

    public void setUserId(Long userId) { this.userId = userId; }
    public void setLoginStatus(String loginStatus) { this.loginStatus = loginStatus; }
}
