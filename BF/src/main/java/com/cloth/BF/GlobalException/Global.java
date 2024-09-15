package com.cloth.BF.GlobalException;

import com.cloth.BF.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Global {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found"+ ex.getMessage());
    }


}
