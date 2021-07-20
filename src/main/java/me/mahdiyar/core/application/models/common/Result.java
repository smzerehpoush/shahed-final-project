package me.mahdiyar.core.application.models.common;

import lombok.Getter;
import me.mahdiyar.core.domain.enums.ResultStatus;

@Getter
public class Result {
    private final int code;
    private final ResultStatus status;
    private final String message;

    public Result(ResultStatus status) {
        this.code = status.getCode();
        this.status = status;
        this.message = status.getMessage();
    }

    public Result(ResultStatus status, String message) {
        this.code = status.getCode();
        this.status = status;
        this.message = message;
    }

    public static Result success() {
        return new Result(ResultStatus.SUCCESS);
    }
}
