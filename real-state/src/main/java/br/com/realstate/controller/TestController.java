package br.com.realstate.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class TestController {
    @Value("${AWS_ACCESS_KEY}")
    private String accessKey;

    @Value("${AWS_SECRET_KEY}")
    private String secretKey;

    @GetMapping("/test")
    public String getMethodName() {
        return null;
    }
    
    @GetMapping("/s3")
    public Object s3Get(@RequestParam String param) {
        param = "https://properties-images-rafael-grotz.s3.sa-east-1.amazonaws.com/Screenshot+2024-01-04+191621.png";
        
        return null;
    }
    
}
