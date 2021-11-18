package me.mahdiyar.core.application.models.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.mahdiyar.core.domain.enums.ResultStatus;

@Getter
@ToString
@EqualsAndHashCode
public class ServiceResponse {
    private static final ServiceResponse successResponse = new ServiceResponse();

    public ServiceResponse() {
        this.result = Result.success();
    }

    public ServiceResponse(ResultStatus resultStatus) {
        this.result = new Result(resultStatus);
    }

    private final Result result;

    public static ServiceResponse success() {
        return successResponse;
    }
}
