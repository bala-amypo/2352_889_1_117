
package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository deviceRepo;

    public DeviceProfileServiceImpl(DeviceProfileRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile d) {
        return deviceRepo.save(d);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return deviceRepo.findByDeviceId(deviceId);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trusted) {
        Optional<DeviceProfile> opt = deviceRepo.findById(id);
        if (opt.isPresent()) {
            DeviceProfile d = opt.get();
            d.setIsTrusted(trusted);
            return deviceRepo.save(d);
        }
        return null;
    }
}
