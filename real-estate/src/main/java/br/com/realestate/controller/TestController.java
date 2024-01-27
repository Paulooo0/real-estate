package br.com.realestate.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.realestate.config.S3Config;
import br.com.realestate.infra.S3.ObjectOperations;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/test")
public class TestController extends S3Config {
    private final ObjectOperations objectOperations;

    public TestController(ObjectOperations objectOperations) {
        this.objectOperations = objectOperations;
    }
    
    @GetMapping("/list")
    public List<String> list() {
        return objectOperations.ListObjects(imagesBucket);
    }
}
