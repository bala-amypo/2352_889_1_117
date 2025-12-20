
package com.example.demo.service;

import com.example.demo.repository.DeviceProfileRepository;

public class DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileService(DeviceProfileRepository repo) {
        this.repo = repo;
    }
}
 