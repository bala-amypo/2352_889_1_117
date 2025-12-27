
package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
        Optional<DeviceProfile> device = service.findByDeviceId(deviceId);
        return device.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/trust/{trusted}")
    public ResponseEntity<DeviceProfile> updateTrust(
            @PathVariable Long id,
            @PathVariable boolean trusted) {
        return ResponseEntity.ok(service.updateTrustStatus(id, trusted));
    }
}
