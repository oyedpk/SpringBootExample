package com.rest.example.restexample.service;

import com.rest.example.restexample.Product;
import com.rest.example.restexample.ProductNotFoundExcpetion;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService{
    static HashMap<Integer, Product> productRepo=new HashMap<Integer, Product>();
    static {
        productRepo.put(1,new Product("dummy1","dummy1 desctipit",1));
        productRepo.put(2,new Product("dummy2","dummy2 desctipit", 2));
    }

    @Override
    public void createProduct(Product product) {
        product.setId(new Random().nextInt());
        productRepo.put(product.getId(),product);
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        if(!productRepo.containsKey(id))
            throw new ProductNotFoundExcpetion(id);
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id,product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.remove(id);
    }

    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }
}
