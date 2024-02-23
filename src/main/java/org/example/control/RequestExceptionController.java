package org.example.control;

import org.example.dto.ResponseErrorDto;
import org.example.exception.RequestValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestExceptionController {

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<ResponseErrorDto> handleValidationException(RequestValidationException ex) {
        return ResponseEntity.badRequest().body(ResponseErrorDto.builder().
                message(ex.getMessage()).
                build());
    }
}