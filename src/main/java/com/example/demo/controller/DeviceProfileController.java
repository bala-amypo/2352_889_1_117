
package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import com.example.demo.repository.DeviceProfileRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    // NO constructor injection
    public DeviceProfileController() {
        this.service = new DeviceProfileService(null);
    }

    @PostMapping
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return device;
    }

    @PutMapping("/{id}/trust")
    public void updateTrust(@PathVariable Long id, @RequestParam boolean trust) {
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
