package com.bootcamp.bank.cuentas.infrastructure.rest;

import com.bootcamp.bank.cuentas.infrastructure.exception.BusinessException;
import com.bootcamp.bank.cuentas.infrastructure.rest.dto.ErrorBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdviceResource {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorBean> runtimeExceptionHandler(BusinessException ex){
        ErrorBean error = ErrorBean
                .builder()
                .codigoEstadoHttp(HttpStatus.NOT_FOUND.toString())
                .mensaje(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
