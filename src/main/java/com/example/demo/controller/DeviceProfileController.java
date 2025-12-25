
package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService deviceService;

    public DeviceProfileController(DeviceProfileService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/register")
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile d) {
        return ResponseEntity.ok(deviceService.registerDevice(d));
    }

    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        Optional<DeviceProfile> d = deviceService.findByDeviceId(deviceId);
        return ResponseEntity.of(d);
    }
}
