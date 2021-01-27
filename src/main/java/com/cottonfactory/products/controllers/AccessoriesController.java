
package com.cottonfactory.products.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AccessoriesController {
    @GetMapping("/api/products/accessories")
    @ResponseStatus(HttpStatus.OK)
    public void getAllAccessories(){

    }
}