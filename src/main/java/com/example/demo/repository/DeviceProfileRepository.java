
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    DeviceProfile findByDeviceId(String deviceId);
}
