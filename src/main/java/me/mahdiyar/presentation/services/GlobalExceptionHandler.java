package me.mahdiyar.presentation.services;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ServiceResponse> handleExceptions(Throwable throwable, WebRequest request) {
        if (throwable instanceof ApplicationException)
            return handleApplicationException((ApplicationException) throwable);
        else if (throwable.getCause() != null)
            return handleExceptions(throwable.getCause(), request);
        else
            return handleOtherExceptions(throwable);
    }

    public ResponseEntity<ServiceResponse> handleApplicationException(ApplicationException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new ServiceResponse(exception.getResultStatus(), exception.getMessage()));
    }

    public ResponseEntity<ServiceResponse> handleOtherExceptions(Throwable throwable) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ServiceResponse(ResultStatus.INTERNAL_SERVER_ERROR));

    }

}
