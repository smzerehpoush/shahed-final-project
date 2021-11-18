package me.mahdiyar.core.domain.repositories;

import me.mahdiyar.core.domain.entities.DeviceDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDataRepository extends JpaRepository<DeviceDataEntity, Long> {
}
