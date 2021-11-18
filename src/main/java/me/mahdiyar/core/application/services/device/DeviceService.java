package me.mahdiyar.core.application.services.device;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mahdiyar.core.application.models.dto.device.requests.SaveDeviceDataRequestDto;
import me.mahdiyar.core.domain.entities.DeviceDataEntity;
import me.mahdiyar.core.domain.repositories.DeviceDataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceService implements IDeviceService {
    private final DeviceDataRepository deviceDataRepository;
    private final DeviceServiceMapper deviceServiceMapper;

    @Override
    public void saveDeviceData(SaveDeviceDataRequestDto request) {
        DeviceDataEntity deviceDataEntity = deviceServiceMapper.toDeviceDataEntity(request);
        logger.info("trying to save device data with request {}", request);
        deviceDataEntity = deviceDataRepository.saveAndFlush(deviceDataEntity);
        logger.info("device data saved successfully with id {}", deviceDataEntity.getId());
    }
}
