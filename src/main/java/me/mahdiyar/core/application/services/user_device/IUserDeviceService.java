package me.mahdiyar.core.application.services.user_device;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.domain.entities.DeviceDataEntity;

import java.util.List;

public interface IUserDeviceService {
    List<DeviceDataEntity> getUserDeviceDataList(long userId, long deviceId) throws ApplicationException;

}
