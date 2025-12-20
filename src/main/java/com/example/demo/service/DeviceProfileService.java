
package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.DeviceProfileRepository;

@Service
public class DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileService(DeviceProfileRepository repo) {
        this.repo = repo;
    }
}
