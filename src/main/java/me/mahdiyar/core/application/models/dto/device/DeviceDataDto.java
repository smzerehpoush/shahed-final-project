package me.mahdiyar.core.application.models.dto.device;

import lombok.Data;

@Data
public class DeviceDataDto {
    private long deviceId;
    private double latitude;
    private double longitude;
    private int altitude;
    private long samplingDate;
    private double btsLatitude;
    private double btsLongitude;
    private int battery;
    private double temperature;
    private double humidity;
}
