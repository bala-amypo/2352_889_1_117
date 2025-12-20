
package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return device;
    }

    @PutMapping("/{id}/trust")
    public String updateTrust(@PathVariable Long id,
                              @RequestParam boolean trust) {
        return "Trust updated";
    }

    @GetMapping("/user/{userId}")
    public List<DeviceProfile> getByUser(@PathVariable Long userId) {
        return List.of();
    }

    @GetMapping("/lookup/{deviceId}")
    public DeviceProfile findByDevice(@PathVariable String deviceId) {
        return null;
    }
}
