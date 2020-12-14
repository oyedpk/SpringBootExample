package com.rest.example.restexample;

import com.rest.example.restexample.Product;
import com.rest.example.restexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<Object> getProducts() {
        return new ResponseEntity(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<Object> addProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity("Product created successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        productService.updateProduct(id,product);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Object> deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }




}
