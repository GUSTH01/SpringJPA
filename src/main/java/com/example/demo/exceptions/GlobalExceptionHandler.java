package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
     public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex){
         Map<String,Object> body = new LinkedHashMap<>();
         body.put("timestamp", LocalDate.now());
                 body.put("status", HttpStatus.NOT_FOUND.value());
                 body.put("error", "Recursio não encontrado");
                 body.put("message", ex.getMessage());
                 return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
     }
     @ExceptionHandler(Exception.class)
     public ResponseEntity<Object> handleGenericException(Exception ex){
         Map<String,Object> body = new LinkedHashMap<>();
         body.put("timestamp", LocalDate.now());
                 body.put("status", HttpStatus.NOT_FOUND.value());
                 body.put("error", "Recursio não encontrado");
                 body.put("message", ex.getMessage());
                 return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
     }

}
