
package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service   // ⭐ REQUIRED
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repository;

    public DeviceProfileServiceImpl(DeviceProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {
        return repository.save(device);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repository.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trusted) {
        DeviceProfile d = repository.findById(id).orElseThrow();
        d.setIsTrusted(trusted);
        return repository.save(d);
    }
}
