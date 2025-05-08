package com.juarcoding.pcmspringboot3.handler;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
    Kode Exception
 -> 99
    VALIDATION      = 01
    DATABASE        = 02
    AUTH            = 03
    MEDIA / FILE    = 04
    EXTERNAL API    = 05
    OTHER           = 99
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    List<Map<String,Object>> errors = new ArrayList<>();
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        errors.clear();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError error : fieldErrors) {
            Map<String,Object> mapError = new HashMap<>();
            mapError.put("field", error.getField());
            mapError.put("message", error.getDefaultMessage());
//            mapError.put("rejected-value", error.getRejectedValue());
            errors.add(mapError);
        }
        Map<String,Object> response = new HashMap<>();
        response.put("server-response", HttpStatus.BAD_REQUEST);
        response.put("error-code", "X0101");
        response.put("message","Data Tidak Valid !!");
        response.put("path",request.getDescription(false));
        response.put("sub-error",errors);
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> illegalArgumentException(IllegalArgumentException ex, HttpServletRequest request){
        Map<String,Object> response = new HashMap<>();
        response.put("server-response", HttpStatus.BAD_REQUEST);
        response.put("error-code", "X0102");
        response.put("message","Format Salah, Tidak Dapat Diproses !!");
        response.put("path",request.getPathInfo());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(UnexpectedRollbackException.class)
    public ResponseEntity<Object> unexpectedRollbackException(UnexpectedRollbackException ex, HttpServletRequest request){
        Map<String,Object> response = new HashMap<>();
        response.put("server-response", HttpStatus.BAD_REQUEST);
        response.put("error-code", "X0201");
        response.put("message","Rollback untuk Transaksi Telah dilakukan");
        response.put("path",request.getPathInfo());
        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }


}
