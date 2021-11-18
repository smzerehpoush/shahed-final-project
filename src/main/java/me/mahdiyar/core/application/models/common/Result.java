package me.mahdiyar.core.application.models.common;

import lombok.Getter;
import me.mahdiyar.core.domain.enums.ResultStatus;

@Getter
public class Result {
    private final int code;
    private final ResultStatus status;

    public Result(ResultStatus status) {
        this.code = status.getCode();
        this.status = status;
    }

    public Result(ResultStatus status, String message) {
        this.code = status.getCode();
        this.status = status;
    }

    public static Result success() {
        return new Result(ResultStatus.SUCCESS);
    }
}
