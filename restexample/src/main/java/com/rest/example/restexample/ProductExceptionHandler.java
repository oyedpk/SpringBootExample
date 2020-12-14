package com.rest.example.restexample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(value= ProductNotFoundExcpetion.class)
    ResponseEntity<Object> excpetion(ProductNotFoundExcpetion productNotFoundExcpetion) {
        return new ResponseEntity("Product not found "+productNotFoundExcpetion.id, HttpStatus.NOT_FOUND);
    }

}
