
package com.example.demo.controller;

import org.springframework.http.*;
import java.util.Optional;
import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    public ResponseEntity<DeviceProfile> lookup(String deviceId) {
        Optional<DeviceProfile> d = service.findByDeviceId(deviceId);
        return ResponseEntity.ok(d.orElse(null));
    }
}
