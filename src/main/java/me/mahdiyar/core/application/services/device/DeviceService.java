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

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceService implements IDeviceService {
    private final DeviceDataRepository deviceDataRepository;
    private final DeviceRepository deviceRepository;
    private final DeviceServiceMapper deviceServiceMapper;
    private final IUserService userService;
    private final Random random = new Random(System.currentTimeMillis());

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
        var existsByDeviceId = deviceRepository.existsAllByUserDeviceId(request.getDeviceId());
        if (existsByDeviceId)
            throw new DuplicateDeviceException();
        var device = new DeviceEntity();
        device.setUserDeviceId(request.getDeviceId());
        device.setName(request.getDeviceName());
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
        var userDevices = deviceRepository.findAllByUserId(user.getId());
        logger.info("user devices count for userId {} is {}", userId, userDevices.size());
        return userDevices;
    }

    @Override
    public DeviceEntity updateDevice(long userId, long deviceId, UpdateDeviceRequestDto request) throws ApplicationException {
        var user = userService.getUser(userId);
        var device = getDevice(deviceId);
        if (!Objects.equals(device.getUser(), user))
            throw new ForbiddenActionException();
        device.setName(request.getDeviceName());
        return deviceRepository.saveAndFlush(device);
    }

    @Override
    public void deleteDevice(long userId, long deviceId) throws ApplicationException {
        var user = userService.getUser(userId);
        var device = getDevice(deviceId);
        if (!Objects.equals(device.getUser(), user))
            throw new ForbiddenActionException();
        device.setDeleted(true);
        deviceRepository.saveAndFlush(device);
    }

    @Override
    public void createTestDataForDevice(long userId, long deviceId) throws ApplicationException {
        var user = userService.getUser(userId);
        var device = getDevice(deviceId);
        if (!Objects.equals(device.getUser(), user))
            throw new ForbiddenActionException();
        var testDataSize = 300 + random.nextInt(200);
        var testData = new ArrayList<DeviceDataEntity>(testDataSize);
        for (int i = 0; i < testDataSize; i++) {
//            39.45-44.54
//                    27.19-63.21
            var latitude = String.valueOf(27 + random.nextDouble() * 12 + ((double) random.nextInt(1000) / 1000000000));
            var longitude = String.valueOf(44 + random.nextDouble() * 17 + ((double) random.nextInt(1000) / 1000000000));

            var btsLatitude = String.valueOf(27 + random.nextDouble() * 12 + (double) random.nextInt(1000) / 1000000000);
            var btsLongitude = String.valueOf(44 + random.nextDouble() * 17 + (double) random.nextInt(1000) / 1000000000);
            var battery = random.nextInt(100);
            var temperature = 25.0 + random.nextInt(5);
            var humidity = 10.0 + random.nextInt(5);
            var altitude = random.nextInt(100);
            var data = new DeviceDataEntity(device.getUserDeviceId(), latitude, longitude, altitude, System.currentTimeMillis(), btsLatitude, btsLongitude, battery, temperature, humidity);
            testData.add(data);
        }
        deviceDataRepository.saveAll(testData);
    }

}
