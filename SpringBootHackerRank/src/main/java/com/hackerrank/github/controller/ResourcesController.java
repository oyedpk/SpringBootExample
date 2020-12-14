package com.hackerrank.github.controller;

import com.hackerrank.github.repository.SampleRepository;
import com.hackerrank.github.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

    @Autowired
    SampleService sampleService;

    @DeleteMapping
    public ResponseEntity deleteAll() {
        sampleService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

}
