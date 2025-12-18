
package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String loginStatus;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
}
