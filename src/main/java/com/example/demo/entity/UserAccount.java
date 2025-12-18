
package com.example.demo.entity;

public class UserAccount{
    @Id
    private Long id;
    private String employeeld;
    private String username;
    private String email;
    private String password;
    private String ADMIN;
    private String USER;
    private String AUDITOR;
    private String ACTIVE;
    private String SUSPENDED;
    private LocalDateTime  createdAt;

}