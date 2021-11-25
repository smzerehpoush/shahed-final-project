package me.mahdiyar.core.domain.repositories;

import me.mahdiyar.core.domain.entities.DeviceDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DeviceDataRepository extends JpaRepository<DeviceDataEntity, Long> {
    List<DeviceDataEntity> findAllByDeviceId(long deviceId);

    @Query("select dd from DeviceDataEntity dd where dd.deviceId = (select d.userDeviceId from DeviceEntity d where d.user.id = ?1)")
    Set<DeviceDataEntity> findAllByUserId(long userId);

}
