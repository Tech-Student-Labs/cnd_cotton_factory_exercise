package com.cottonfactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductApiHome {

    @GetMapping
    public String welcomeToDocs() {
        return "Welcome home, Swagger is live!";
    }
}
