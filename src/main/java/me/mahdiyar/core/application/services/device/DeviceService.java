package me.mahdiyar.core.application.services.device;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.exceptions.ForbiddenActionException;
import me.mahdiyar.core.application.exceptions.device.DeviceNotFoundException;
import me.mahdiyar.core.application.exceptions.device.DuplicateDeviceException;
import me.mahdiyar.core.application.models.dto.device.requests.CreateDeviceRequestDto;
import me.mahdiyar.core.application.models.dto.device.requests.SaveDeviceDataRequestDto;
import me.mahdiyar.core.application.models.dto.device.requests.UpdateDeviceRequestDto;
import me.mahdiyar.core.application.services.user.IUserService;
import me.mahdiyar.core.domain.entities.DeviceDataEntity;
import me.mahdiyar.core.domain.entities.DeviceEntity;
import me.mahdiyar.core.domain.repositories.DeviceDataRepository;
import me.mahdiyar.core.domain.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceService implements IDeviceService {
    private final DeviceDataRepository deviceDataRepository;
    private final DeviceRepository deviceRepository;
    private final DeviceServiceMapper deviceServiceMapper;
    private final IUserService userService;

    @Override
    public void saveDeviceData(SaveDeviceDataRequestDto request) {
        DeviceDataEntity deviceDataEntity = deviceServiceMapper.toDeviceDataEntity(request);
        logger.info("trying to save device data with request {}", request);
        deviceDataEntity = deviceDataRepository.saveAndFlush(deviceDataEntity);
        logger.info("device data saved successfully with id {}", deviceDataEntity.getId());
    }

    @Override
    public DeviceEntity createDevice(long userId, CreateDeviceRequestDto request) throws ApplicationException {
        var user = userService.getUser(userId);
        var existsByDeviceId = deviceRepository.existsAllByUserDeviceId(request.deviceId);
        if (existsByDeviceId)
            throw new DuplicateDeviceException();
        var device = new DeviceEntity();
        device.setUserDeviceId(request.deviceId);
        device.setName(request.deviceName);
        device.setUser(user);
        return deviceRepository.saveAndFlush(device);
    }

    @Override
    public DeviceEntity getDevice(long deviceId) throws ApplicationException {
        return deviceRepository.findAllByUserDeviceId(deviceId).orElseThrow(DeviceNotFoundException::new);
    }

    @Override
    public Set<DeviceEntity> getUserDevices(long userId) throws ApplicationException {
        var user = userService.getUser(userId);
        var userDevices = deviceRepository.findAllByUserId(userId);
        logger.info("user devices count for userId {} is {}", userId, userDevices.size());
        return userDevices;
    }

    @Override
    public DeviceEntity updateDevice(long userId, long deviceId, UpdateDeviceRequestDto request) throws ApplicationException {
        var device = getDevice(deviceId);
        if (!Objects.equals(device.getUser().getId(), userId))
            throw new ForbiddenActionException();
        device.setName(request.getDeviceName());
        return deviceRepository.saveAndFlush(device);
    }

    @Override
    public void deleteDevice(long userId, long deviceId) throws ApplicationException {
        var device = getDevice(deviceId);
        if (!Objects.equals(device.getUser().getId(), userId))
            throw new ForbiddenActionException();
        device.setDeleted(true);
        deviceRepository.saveAndFlush(device);
    }

}
