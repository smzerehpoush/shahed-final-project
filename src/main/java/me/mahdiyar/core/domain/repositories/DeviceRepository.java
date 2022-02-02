package me.mahdiyar.core.domain.repositories;

import me.mahdiyar.core.domain.entities.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
    Optional<DeviceEntity> findAllByUserDeviceId(long deviceId);

    Set<DeviceEntity> findAllByUserIdAndDeletedFalse(long userId);

    boolean existsAllByUserDeviceId(long deviceId);
}
