package me.mahdiyar.core.application.models.dto.device.responses;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.device.DeviceDto;

import java.util.Set;

@Data
public class GetUserDevicesResponseDto extends ServiceResponse {
    private Set<DeviceDto> devices;

    public GetUserDevicesResponseDto(Set<DeviceDto> devices) {
        this.devices = devices;
    }
}
