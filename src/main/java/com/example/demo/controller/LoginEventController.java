
package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

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
