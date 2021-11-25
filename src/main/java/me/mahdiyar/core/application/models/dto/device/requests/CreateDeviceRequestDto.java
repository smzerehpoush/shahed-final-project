package me.mahdiyar.core.application.models.dto.device.requests;

import lombok.Data;

@Data
public class CreateDeviceRequestDto {
    public String deviceName;
    public long deviceId;
}
