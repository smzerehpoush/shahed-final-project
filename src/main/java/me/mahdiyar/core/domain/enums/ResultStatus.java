package me.mahdiyar.core.domain.enums;

import lombok.Getter;

@Getter
public enum ResultStatus {
    SUCCESS,
    INTERNAL_SERVER_ERROR,
    USER_NOT_FOUND,
    USERNAME_ALREADY_EXISTS,
    ;
    int code;
    String message;

}
