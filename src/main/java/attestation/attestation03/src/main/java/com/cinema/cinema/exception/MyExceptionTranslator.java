package com.cinema.cinema.exception;

import com.cinema.cinema.dto.error.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionTranslator {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleNotFoundException (NotFoundException ex){
        return processError(ex, ex.getMessage(), ex.getCause().toString());
    }

    private ErrorDto processError (Exception ex,
                                   String error,
                                   String description) {
        return new ErrorDto(error, description);
    }
}
