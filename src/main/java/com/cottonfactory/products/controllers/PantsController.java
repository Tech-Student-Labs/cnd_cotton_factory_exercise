package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Pants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PantsController {

    @GetMapping("/api/products/pants")
    public List<Pants> getAllPants() {
        List<Pants> pantsList = new ArrayList<>();
        Pants pants = new Pants();
        pants.setType("athletic");
        pantsList.add(pants);
        return pantsList;
    }
}
