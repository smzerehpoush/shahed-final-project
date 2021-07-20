package me.mahdiyar.core.application.exceptions.users;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApplicationException {
    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, ResultStatus.USER_NOT_FOUND);
    }
}
