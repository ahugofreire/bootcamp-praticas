package com.meli.dealership.exceptions;

import com.meli.dealership.dto.ExceptionPayloadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class ExceptionAdviceHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleUserAlreadyExistsException(ResourceNotFoundException exception){
        ExceptionPayloadDTO exceptionPayLoad = ExceptionPayloadDTO.builder()
                .timestamp(LocalDateTime.now())
                .title("Resource not found")
                .statusCode(HttpStatus.NOT_FOUND.value())
                .description(exception.getMessage())
                .build();

        return new ResponseEntity<>(exceptionPayLoad, HttpStatus.NOT_FOUND);
    }
}
