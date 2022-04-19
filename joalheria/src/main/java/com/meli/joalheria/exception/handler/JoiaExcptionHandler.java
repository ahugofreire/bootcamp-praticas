package com.meli.joalheria.exception.handler;

import com.meli.joalheria.dto.ErrorDTO;
import com.meli.joalheria.exception.JoiaNaoEncontradaExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class JoiaExcptionHandler {

    @ExceptionHandler(JoiaNaoEncontradaExcecao.class)
    protected ResponseEntity<ErrorDTO> handleErrors(JoiaNaoEncontradaExcecao e, HttpServletRequest req) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .errorMessage(e.getMessage())
                .path(req.getRequestURI())
                .build();

        return ResponseEntity.badRequest().body(errorDTO);
    }
}
