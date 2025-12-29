
package com.example.demo.repository;

import com.example.demo.entity.DeviceProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    Optional<DeviceProfile> findByDeviceId(String deviceId);
    List<DeviceProfile> findByUserId(Long userId);
}

// package com.example.demo.repository;

// import com.example.demo.entity.*;
// import java.util.*;
// public interface DeviceProfileRepository {
//     DeviceProfile save(DeviceProfile d);
//     Optional<DeviceProfile> findById(Long id);
//     Optional<DeviceProfile> findByDeviceId(String deviceId);
// }
