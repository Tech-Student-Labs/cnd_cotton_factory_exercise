package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.services.PantsService;
import com.cottonfactory.products.services.dtos.PantsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PantsController {

    @Autowired
    private PantsService pantsService;

    @GetMapping("/api/products/pants")
    public List<PantsDto> getAllPants() {
        return pantsService.findAllPants();
    }
}
