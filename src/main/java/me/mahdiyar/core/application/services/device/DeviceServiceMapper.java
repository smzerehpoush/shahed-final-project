package me.mahdiyar.core.application.services.device;

import me.mahdiyar.core.application.models.dto.device.requests.SaveDeviceDataRequestDto;
import me.mahdiyar.core.domain.entities.DeviceDataEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeviceServiceMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "id", target = "deviceId")
    @Mapping(source = "lat", target = "latitude")
    @Mapping(source = "lon", target = "longitude")
    @Mapping(source = "alt", target = "altitude")
    @Mapping(source = "dt", target = "samplingDate")
    @Mapping(source = "latb", target = "btsLatitude")
    @Mapping(source = "lonb", target = "btsLongitude")
    @Mapping(source = "vbat", target = "battrey")
    DeviceDataEntity toDeviceDataEntity(SaveDeviceDataRequestDto request);

}
