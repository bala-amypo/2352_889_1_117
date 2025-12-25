
package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.DeviceProfile;

public interface DeviceProfileService {
    DeviceProfile registerDevice(DeviceProfile d);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    DeviceProfile updateTrustStatus(Long id, boolean trusted);
}
