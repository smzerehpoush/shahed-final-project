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
    @Mapping(target = "battrey", source = "vbat")
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

    DeviceDataDto toDeviceDataDto(DeviceDataEntity deviceDataEntity);

    @Mapping(target = "deviceDataList", source = "devices")
    default GetUserDeviceDataResponseDto toGetUserDeviceDataResponseDto(List<DeviceDataEntity> devices) {
        var deviceDataDtoList = devices.stream().map(this::toDeviceDataDto).collect(Collectors.toList());
        return new GetUserDeviceDataResponseDto(deviceDataDtoList);
    }
}
