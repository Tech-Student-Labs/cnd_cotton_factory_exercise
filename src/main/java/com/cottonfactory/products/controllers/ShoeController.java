package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.ShoeProduct;
import com.cottonfactory.products.services.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeController {

    @Autowired
    private ShoeService shoeService;

    @PostMapping("/api/products/shoe")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShoeProduct(@RequestBody ShoeProduct shoeProduct){
        shoeService.addShoeProduct(shoeProduct);
    }

}
