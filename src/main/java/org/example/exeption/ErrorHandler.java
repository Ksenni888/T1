package org.example.exeption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public NoInformationFoundException handleNoInformationFoundException(final NoInformationFoundException e) {
        log.warn(e.getMessage(), e);
        return new NoInformationFoundException(e.getMessage());
    }
}