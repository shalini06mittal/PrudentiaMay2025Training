package com.boot.demo.springbootdemo.exception;

import com.boot.demo.springbootdemo.utility.AppConstants;
import com.boot.demo.springbootdemo.utility.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//@RestControllerAdvice
public class MyGlobalHandler {
    MyGlobalHandler(){
        System.out.println("Global handleer");
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleResourceNotFoundException(Exception ex) {
        System.out.println("global exception handler");
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex){
        Map<String, Object> map = new HashMap<>();
        map.put(AppConstants.STATUS, Status.FAILURE);
            String msg = ((MethodArgumentNotValidException) ex).getAllErrors()
                    .stream().map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));
            map.put("error",msg);
            return ResponseEntity.badRequest().body(map);

    }


}
