package com.miqueias_r.infrastructure.rest.handler;

import com.miqueias_r.core.exception.CarteiraException;
import com.miqueias_r.core.exception.TransacaoException;
import com.miqueias_r.core.exception.UsuarioException;
import com.miqueias_r.infrastructure.exception.ServicoExternoException;
import com.miqueias_r.infrastructure.rest.dto.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioException(UsuarioException ex) {

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new ErrorResponse(ex.getStatusCode(), ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(CarteiraException.class)
    public ResponseEntity<ErrorResponse> handleCarteiraException(CarteiraException ex) {

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new ErrorResponse(ex.getStatusCode(), ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(TransacaoException.class)
    public ResponseEntity<ErrorResponse> handleTransacaoException(TransacaoException ex) {

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new ErrorResponse(ex.getStatusCode(), ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(ServicoExternoException.class)
    public ResponseEntity<ErrorResponse> handleServicoExternoException(ServicoExternoException ex) {

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new ErrorResponse(ex.getStatusCode(), ex.getMessage(), LocalDateTime.now()));
    }
}
