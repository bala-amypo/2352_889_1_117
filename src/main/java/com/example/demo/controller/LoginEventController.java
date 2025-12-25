
package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login-events")
public class LoginEventController {

    private final LoginEventService loginService;

    public LoginEventController(LoginEventService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/record")
    public ResponseEntity<LoginEvent> record(@RequestBody LoginEvent e) {
        return ResponseEntity.ok(loginService.recordLogin(e));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<LoginEvent>> getByUser(@PathVariable Long id) {
        return ResponseEntity.ok(loginService.getEventsByUser(id));
    }
}
