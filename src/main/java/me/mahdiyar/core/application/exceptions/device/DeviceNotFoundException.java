package me.mahdiyar.core.application.exceptions.device;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

public class DeviceNotFoundException extends ApplicationException {
    public DeviceNotFoundException() {
        super(HttpStatus.NOT_FOUND, ResultStatus.DEVICE_NOT_FOUND);
    }
}
