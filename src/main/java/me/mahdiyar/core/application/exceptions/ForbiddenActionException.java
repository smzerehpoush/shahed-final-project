package me.mahdiyar.core.application.exceptions;

import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

public class ForbiddenActionException extends ApplicationException {
    public ForbiddenActionException() {
        super(HttpStatus.FORBIDDEN, ResultStatus.FORBIDDEN_ACTION);
    }
}
