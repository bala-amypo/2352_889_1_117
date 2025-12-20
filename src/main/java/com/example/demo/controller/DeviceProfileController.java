
package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

@RestController
@RequestMapping("/api/devices")
@Tag(name = "device-profile-controller")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

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
    public DeviceProfile getByDevice(@PathVariable String deviceId) {
        return new DeviceProfile();
    }
}
