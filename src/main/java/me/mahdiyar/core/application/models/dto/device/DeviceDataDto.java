package me.mahdiyar.core.application.models.dto.device;

import lombok.Data;

@Data
public class DeviceDataDto {
    private long deviceId;
    private String latitude;
    private String longitude;
    private int altitude;
    private long samplingDate;
    private String btsLatitude;
    private String btsLongitude;
    private int battrey;
    private double temperature;
    private double humidity;
}
