
package com.example.demo.repository;

import com.example.demo.entity.*;
import java.util.*;
public interface DeviceProfileRepository {
    DeviceProfile save(DeviceProfile d);
    Optional<DeviceProfile> findById(Long id);
    Optional<DeviceProfile> findByDeviceId(String deviceId);
}
