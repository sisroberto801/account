package com.devsu.account.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity fatalErrorUnexpectedException(HttpServletRequest request, Exception e, WebRequest webRequest) {
        log.info("internal server {}", request.getRequestURI());
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorMessage data = new ErrorMessage(e, request.getRequestURI(), status.value());
        return new ResponseEntity<>(data, status);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity badRequest(HttpServletRequest request, Exception e) {
        log.info("bad request {}", request.getRequestURI());

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessage data = new ErrorMessage(e, request.getRequestURI(), status.value());
        return new ResponseEntity<>(data, status);
    }
}

