package me.mahdiyar.core.application.exceptions;

import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

public class AuthenticationException extends ApplicationException {
    public AuthenticationException() {
        super(HttpStatus.UNAUTHORIZED, ResultStatus.USERNAME_OR_PASSWORD_IS_INCORRECT);
    }
}
