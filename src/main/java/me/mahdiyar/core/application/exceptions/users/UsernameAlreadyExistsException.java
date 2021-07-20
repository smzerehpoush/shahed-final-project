package me.mahdiyar.core.application.exceptions.users;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends ApplicationException {
    public UsernameAlreadyExistsException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY, ResultStatus.USERNAME_ALREADY_EXISTS);
    }
}
