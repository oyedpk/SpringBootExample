package com.rest.example.restexample;

public class ProductNotFoundExcpetion extends RuntimeException {
    Integer id;
    public ProductNotFoundExcpetion(int id){
        this.id=id;
    }
}
