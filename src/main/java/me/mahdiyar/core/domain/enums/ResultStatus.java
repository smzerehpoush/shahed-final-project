package me.mahdiyar.core.domain.enums;

import lombok.Getter;

@Getter
public enum ResultStatus {
    INTERNAL_SERVER_ERROR(-1),
    SUCCESS(0),
    FORBIDDEN_ACTION(1),
    UNAUTHORIZED(2),

    USER_NOT_FOUND(1000),
    USERNAME_ALREADY_EXISTS(1001),
    USERNAME_OR_PASSWORD_IS_INCORRECT(1002),
    DEVICE_NOT_FOUND(1003),
    DUPLICATE_DEVICE(1004);

    ResultStatus(int code) {
        this.code = code;
    }

    int code;
}
