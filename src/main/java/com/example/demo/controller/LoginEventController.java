
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logins")
@Tag(name = "Login Event Controller")
public class LoginEventController {

    @PostMapping("/record")
    public String recordLogin(@RequestBody Object loginEvent) {
        return "Login event recorded";
    }

    @GetMapping("/user/{userId}")
    public String getLoginsByUser(@PathVariable Long userId) {
        return "Login events for user " + userId;
    }

    @GetMapping("/suspicious/{userId}")
    public String getSuspiciousLogins(@PathVariable Long userId) {
        return "Suspicious logins for user " + userId;
    }

    @GetMapping
    public String getAllLogins() {
        return "All login events";
    }
}
