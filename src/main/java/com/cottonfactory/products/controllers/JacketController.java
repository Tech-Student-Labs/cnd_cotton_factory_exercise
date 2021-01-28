package com.cottonfactory.products.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.services.JacketService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("api/products")
@Api(tags = "jackets")
public class JacketController {

    private JacketService service;

    public JacketController(JacketService service){
        this.service = service;
    }

    @PostMapping("/jackets")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Jacket createJacket(@RequestBody Jacket jacket){
        return service.createJacket(jacket);
    }


}
