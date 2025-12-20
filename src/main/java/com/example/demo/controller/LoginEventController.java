
package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController() {
        this.service = new LoginEventService(null, null);
    }

    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event) {
        return event;
    }

    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return List.of();
    }

    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> suspicious(@PathVariable Long userId) {
        return List.of();
    }

    @GetMapping
    public List<LoginEvent> getAll() {
        return List.of();
    }
}
