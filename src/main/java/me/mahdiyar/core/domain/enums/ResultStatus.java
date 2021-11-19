package me.mahdiyar.core.domain.enums;

import lombok.Getter;

@Getter
public enum ResultStatus {
    SUCCESS(0),
    INTERNAL_SERVER_ERROR(500),
    UNAUTHORIZED(401),
    USER_NOT_FOUND(1000),
    USERNAME_ALREADY_EXISTS(1001),
    USERNAME_OR_PASSWORD_IS_INCORRECT(1002);

    ResultStatus(int code) {
        this.code = code;
    }

    int code;
}
