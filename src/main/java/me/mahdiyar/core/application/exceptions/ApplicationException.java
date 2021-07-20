package me.mahdiyar.core.application.exceptions;

import lombok.Getter;
import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends Exception {
    protected ApplicationException(HttpStatus httpStatus, ResultStatus resultStatus) {
        this.httpStatus = httpStatus;
        this.resultStatus = resultStatus;
    }

    protected ApplicationException(String message, HttpStatus httpStatus, ResultStatus resultStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.resultStatus = resultStatus;
    }

    protected ApplicationException(String message, Throwable cause, HttpStatus httpStatus, ResultStatus resultStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.resultStatus = resultStatus;
    }

    protected ApplicationException(Throwable cause, HttpStatus httpStatus, ResultStatus resultStatus) {
        super(cause);
        this.httpStatus = httpStatus;
        this.resultStatus = resultStatus;
    }

    private final HttpStatus httpStatus;
    private final ResultStatus resultStatus;
}
