
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LoginEvent;
import java.util.List;


public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    DeviceProfile findByDeviceId(String deviceId);
}
