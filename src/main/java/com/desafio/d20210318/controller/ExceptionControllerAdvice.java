package com.desafio.d20210318.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.desafio.d20210318.exception.DesafioImplException;



/**
 * Created by juliocornejo
 */
@ControllerAdvice
@ResponseBody
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LogManager.getLogger(ExceptionControllerAdvice.class);
    
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @ExceptionHandler(DesafioImplException.class)
    public ResponseEntity<ApiError> handlerException(DesafioImplException lie) {
        LOGGER.error("Error en desafio: {} .", lie.getMessage());
        
        return new ResponseEntity<>(new ApiError(HttpStatus.ACCEPTED.value(), lie.getMessage()),
                HttpStatus.ACCEPTED);
    }
    
    @ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ApiError> handlerException(NumberFormatException nfe) {
        LOGGER.error("Error en desafio: {} .", nfe.getMessage());

        return new ResponseEntity<>(new ApiError(HttpStatus.ALREADY_REPORTED.value(), nfe.getMessage()),
                HttpStatus.ALREADY_REPORTED);
    }
    
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handlerException(Exception e) {
        LOGGER.error("Error en desafio: {} .", e.getMessage());
        return new ResponseEntity<>(new ApiError(HttpStatus.ALREADY_REPORTED.value(), e.getMessage()),
                HttpStatus.ALREADY_REPORTED);
    }
    

}