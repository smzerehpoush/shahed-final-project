package me.mahdiyar.core.application.models.dto.device.requests;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceRequest;

@Data
public class SaveDeviceDataRequestDto extends ServiceRequest {
    private long id;
    private String lat;
    private String lon;
    private int alt;
    private long dt;
    private String latb;
    private String lonb;
    private int vbat;
}
