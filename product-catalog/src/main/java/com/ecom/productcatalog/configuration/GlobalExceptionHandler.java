package com.ecom.productcatalog.configuration;

import com.ecom.productcatalog.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity handleCustomException(Exception ex, WebRequest req) {
        log.error("Oh no error occurred");
        return handleExceptionInternal(ex, "Something wrong", null, HttpStatus.BAD_REQUEST, req);
    }
}
