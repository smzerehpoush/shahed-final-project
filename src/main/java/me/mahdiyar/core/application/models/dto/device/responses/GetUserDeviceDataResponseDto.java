package me.mahdiyar.core.application.models.dto.device.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.device.DeviceDataDto;

import java.util.List;

@Data
@AllArgsConstructor
public class GetUserDeviceDataResponseDto extends ServiceResponse {
    private List<DeviceDataDto> deviceDataList;
}
