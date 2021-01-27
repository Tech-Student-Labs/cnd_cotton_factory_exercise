package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.DressEntity;
import com.cottonfactory.products.services.DressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class DressController {

    @Autowired
    private DressService dressService;

    @GetMapping("/dress")
    public List<DressEntity> getAllDress() {
        return dressService.getAllDress();
    }
}
