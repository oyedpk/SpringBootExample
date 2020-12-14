package com.rest.example.restexample.service;

import com.rest.example.restexample.Product;
import java.util.Collection;

public interface ProductService {

    void createProduct(Product product);
    void updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
    Collection<Product> getProducts();
}
