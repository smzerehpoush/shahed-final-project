package me.mahdiyar.core.application.services.device;

import me.mahdiyar.core.application.models.dto.device.DeviceDataDto;
import me.mahdiyar.core.application.models.dto.device.DeviceDto;
import me.mahdiyar.core.application.models.dto.device.requests.SaveDeviceDataRequestDto;
import me.mahdiyar.core.application.models.dto.device.responses.CreateDeviceResponseDto;
import me.mahdiyar.core.application.models.dto.device.responses.GetUserDeviceDataResponseDto;
import me.mahdiyar.core.application.models.dto.device.responses.GetUserDevicesResponseDto;
import me.mahdiyar.core.application.models.dto.device.responses.UpdateDeviceResponseDto;
import me.mahdiyar.core.domain.entities.DeviceDataEntity;
import me.mahdiyar.core.domain.entities.DeviceEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DeviceServiceMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "deviceId", source = "id")
    @Mapping(target = "latitude", source = "lat")
    @Mapping(target = "longitude", source = "lon")
    @Mapping(target = "altitude", source = "alt")
    @Mapping(target = "samplingDate", source = "dt")
    @Mapping(target = "btsLatitude", source = "latb")
    @Mapping(target = "btsLongitude", source = "lonb")
    @Mapping(target = "battery", source = "vbat")
    DeviceDataEntity toDeviceDataEntity(SaveDeviceDataRequestDto request);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "id", source = "userDeviceId")
    DeviceDto toDeviceDto(DeviceEntity deviceEntity);

    @Mapping(target = "device", source = "device")
    CreateDeviceResponseDto toCreateDeviceResponseDto(DeviceEntity device);

    @Mapping(target = "device", source = "device")
    UpdateDeviceResponseDto toUpdateDeviceResponseDto(DeviceEntity device);

    @Mapping(target = "devices", source = "devices")
    default GetUserDevicesResponseDto toGetUserDevicesResponseDto(Set<DeviceEntity> devices) {
        var deviceDtoList = devices.stream().map(this::toDeviceDto).collect(Collectors.toSet());
        return new GetUserDevicesResponseDto(deviceDtoList);
    }

    default DeviceDataDto toDeviceDataDto(DeviceDataEntity deviceDataEntity) {
        try {
            var deviceData = new DeviceDataDto();
            deviceData.setDeviceId(deviceDataEntity.getDeviceId());
            deviceData.setLatitude(Double.parseDouble(deviceDataEntity.getLatitude()));
            deviceData.setLongitude(Double.parseDouble(deviceDataEntity.getLongitude()));
            deviceData.setAltitude(deviceDataEntity.getAltitude());
            deviceData.setSamplingDate(deviceDataEntity.getSamplingDate());
            deviceData.setBtsLatitude(Double.parseDouble(deviceDataEntity.getBtsLatitude()));
            deviceData.setBtsLongitude(Double.parseDouble(deviceDataEntity.getBtsLongitude()));
            deviceData.setBattery(deviceDataEntity.getBattery());
            deviceData.setTemperature(deviceDataEntity.getTemperature());
            deviceData.setHumidity(deviceDataEntity.getHumidity());

            return deviceData;
        } catch (Exception e) {
            return null;
        }
    }

    @Mapping(target = "deviceDataList", source = "devices")
    default GetUserDeviceDataResponseDto toGetUserDeviceDataResponseDto(List<DeviceDataEntity> devices) {

        var deviceDataDtoList = new ArrayList<DeviceDataDto>();
        for (DeviceDataEntity data : devices) {
            var dto = toDeviceDataDto(data);
            if (dto != null) {
                deviceDataDtoList.add(dto);
            }
        }
        return new GetUserDeviceDataResponseDto(deviceDataDtoList);
    }
}
