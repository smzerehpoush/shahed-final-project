package me.mahdiyar.core.application.models.dto.device.responses;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.device.DeviceDataDto;

import java.util.List;

@Data
public class GetUserDeviceDataResponseDto extends ServiceResponse {
    private List<DeviceDataDto> deviceDataList;

    public GetUserDeviceDataResponseDto(List<DeviceDataDto> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }
}
