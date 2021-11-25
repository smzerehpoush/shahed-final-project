package me.mahdiyar.presentation.services;

import lombok.extern.slf4j.Slf4j;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.domain.enums.ResultStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ServiceResponse> handleExceptions(Exception ex) {
        logger.error("application exception", ex);
        if (ex instanceof ApplicationException)
            return handleApplicationException((ApplicationException) ex);
        else if (ex.getCause() != null)
            return handleExceptions((Exception) ex.getCause());
        else
            return handleOtherExceptions(ex);
    }

    public ResponseEntity<ServiceResponse> handleApplicationException(ApplicationException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(new ServiceResponse(exception.getResultStatus()));
    }

    public ResponseEntity<ServiceResponse> handleOtherExceptions(Throwable throwable) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ServiceResponse(ResultStatus.INTERNAL_SERVER_ERROR));

    }

}
