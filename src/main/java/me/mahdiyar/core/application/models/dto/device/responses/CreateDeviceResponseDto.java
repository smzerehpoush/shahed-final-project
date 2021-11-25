package me.mahdiyar.core.application.models.dto.device.responses;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.device.DeviceDto;

@Data
public class CreateDeviceResponseDto extends ServiceResponse {
    private DeviceDto device;
}
