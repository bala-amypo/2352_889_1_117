
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

@RestController
@RequestMapping("/login-events")
public class LoginEventController {

    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public LoginEvent record(@RequestBody LoginEvent event) {
        return loginService.recordLogin(event);
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return loginService.getEventsByUser(userId);
    }

    @GetMapping("/user/{userId}/suspicious")
    public List<LoginEvent> getSuspicious(@PathVariable Long userId) {
        return loginService.getSuspiciousLogins(userId);
    }
}
