





public interface DeviceProfileRepository extends JpaRepository<DeviceProfile, Long> {
    DeviceProfile findByDeviceId(String deviceId);
}
