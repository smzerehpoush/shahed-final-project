package me.mahdiyar.core.application.exceptions;

import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

public class UnauthorizedUserException extends ApplicationException {
    public UnauthorizedUserException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, ResultStatus.UNAUTHORIZED);
    }
}
