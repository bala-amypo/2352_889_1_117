// package com.example.demo.controller;

// import com.example.demo.entity.DeviceProfile;
// import com.example.demo.service.DeviceProfileService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/devices")
// public class DeviceProfileController {

//     private final DeviceProfileService deviceService;

//     public DeviceProfileController(DeviceProfileService deviceService) {
//         this.deviceService = deviceService;
//     }

//     @PostMapping
//     public ResponseEntity<DeviceProfile> register(@RequestBody DeviceProfile device) {
//         return ResponseEntity.ok(deviceService.registerDevice(device));
//     }

//     @PutMapping("/{id}/trust")
//     public ResponseEntity<DeviceProfile> updateTrust(
//             @PathVariable Long id,
//             @RequestParam boolean trust) {
//         return ResponseEntity.ok(deviceService.updateTrustStatus(id, trust));
//     }

//     @GetMapping("/user/{userId}")
//     public ResponseEntity<List<DeviceProfile>> getByUser(@PathVariable Long userId) {
//         return ResponseEntity.ok(deviceService.getDevicesByUser(userId));
//     }

//     @GetMapping("/lookup/{deviceId}")
//     public ResponseEntity<DeviceProfile> lookup(@PathVariable String deviceId) {
//         return ResponseEntity.ok(
//                 deviceService.findByDeviceId(deviceId).orElse(null)
//         );
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.http.*;

public class DeviceProfileController {
    private final DeviceProfileService service;
    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }
    public ResponseEntity<DeviceProfile> lookup(String id) {
        return ResponseEntity.ok(service.findByDeviceId(id).orElse(null));
    }
}