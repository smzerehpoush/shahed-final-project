package me.mahdiyar.core.application.models.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.mahdiyar.core.domain.enums.ResultStatus;

@Getter
@ToString
@EqualsAndHashCode
public class ServiceResponse {
    public ServiceResponse() {
        this.result = Result.success();
    }

    public ServiceResponse(ResultStatus resultStatus) {
        this.result = new Result(resultStatus);
    }

    public ServiceResponse(ResultStatus resultStatus, String message) {
        this.result = new Result(resultStatus, message);
    }

    private final Result result;
}
