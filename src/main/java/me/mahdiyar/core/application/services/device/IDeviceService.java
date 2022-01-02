package me.mahdiyar.core.application.services.device;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.dto.device.requests.CreateDeviceRequestDto;
import me.mahdiyar.core.application.models.dto.device.requests.SaveDeviceDataRequestDto;
import me.mahdiyar.core.application.models.dto.device.requests.UpdateDeviceRequestDto;
import me.mahdiyar.core.domain.entities.DeviceEntity;

import java.util.Set;

public interface IDeviceService {
    void saveDeviceData(SaveDeviceDataRequestDto request) throws ApplicationException;

    DeviceEntity createDevice(long userId, CreateDeviceRequestDto request) throws ApplicationException;

    DeviceEntity getDevice(long deviceId) throws ApplicationException;

    Set<DeviceEntity> getUserDevices(long userId) throws ApplicationException;

    DeviceEntity updateDevice(long userId, long deviceId, UpdateDeviceRequestDto request) throws ApplicationException;

    void deleteDevice(long userId, long deviceId) throws ApplicationException;

    void createTestDataForDevice(long userId, long deviceId) throws ApplicationException;
}
