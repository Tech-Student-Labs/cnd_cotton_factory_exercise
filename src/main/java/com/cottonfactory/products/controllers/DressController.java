package com.cottonfactory.products.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class DressController {

    @GetMapping("/dress")
    public List<?> getAllDress(){
        return new ArrayList();
    }
}
