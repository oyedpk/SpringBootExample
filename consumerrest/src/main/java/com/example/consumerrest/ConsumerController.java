package com.example.consumerrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/template/product")
public class ConsumerController {

    public static String PRODUCT_URI="http://localhost:9090/product/";

    @Value("${welcome.message:default_value}")
    String welcomeText;

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String consumerProducts(){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity=new HttpEntity<String>(httpHeaders);
        return restTemplate.exchange(PRODUCT_URI, HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity=new HttpEntity<Product>(product,httpHeaders);
        return restTemplate.exchange(PRODUCT_URI, HttpMethod.POST,entity,String.class).getBody();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable Integer id, @RequestBody Product product){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity=new HttpEntity<Product>(product,httpHeaders);
        return restTemplate.exchange(PRODUCT_URI+id, HttpMethod.PUT,entity,String.class).getBody();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable Integer id){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity=new HttpEntity<Product>(httpHeaders);
        return restTemplate.exchange(PRODUCT_URI+id, HttpMethod.DELETE,entity,String.class).getBody();
    }

    @RequestMapping(value = "/welcome")
    public String testConfigServer(){
        return welcomeText;
    }


}
