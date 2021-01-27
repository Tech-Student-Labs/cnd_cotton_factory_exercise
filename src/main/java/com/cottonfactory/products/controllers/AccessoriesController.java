
package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Accessories;
import com.cottonfactory.products.services.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessoriesController {

    @Autowired
    AccessoriesService accessoriesService;

    @GetMapping("/api/products/accessories")
    @ResponseStatus(HttpStatus.OK)
    public List<Accessories> getAllAccessories(){
        return accessoriesService.getAllAccessories();
    }
}