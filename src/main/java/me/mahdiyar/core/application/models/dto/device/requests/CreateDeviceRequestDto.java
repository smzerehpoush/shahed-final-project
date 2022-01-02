package me.mahdiyar.core.application.models.dto.device.requests;

import lombok.Data;

@Data
public class CreateDeviceRequestDto {
    private String deviceName;
    private long deviceId;
}
