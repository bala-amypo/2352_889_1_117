
package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_profiles")
public class DeviceProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String deviceId;
    private Long userId;
    private String deviceType;
    private Boolean isTrusted;
    private String osVersion;
    private LocalDateTime lastSeen;
    
    public DeviceProfile() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getDeviceType() {
        return deviceType;
    }
    
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    
    public Boolean getIsTrusted() {
        return isTrusted;
    }
    
    public void setIsTrusted(Boolean isTrusted) {
        this.isTrusted = isTrusted;
    }
    
    public String getOsVersion() {
        return osVersion;
    }
    
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    
    public LocalDateTime getLastSeen() {
        return lastSeen;
    }
    
    public void setLastSeen(LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }
}