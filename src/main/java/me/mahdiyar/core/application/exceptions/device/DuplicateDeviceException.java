package me.mahdiyar.core.application.exceptions.device;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

public class DuplicateDeviceException extends ApplicationException {

    public DuplicateDeviceException() {
        super(HttpStatus.BAD_REQUEST, ResultStatus.DUPLICATE_DEVICE);
    }
}
