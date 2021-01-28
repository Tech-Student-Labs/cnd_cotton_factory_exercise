package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Skirt;
import com.cottonfactory.products.repositories.SkirtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class SkirtsController {
    @Autowired
    private SkirtsRepository skirtsRepository;

    @GetMapping("skirts")
    public List<Skirt> getAllSkirts() {
        return skirtsRepository.findAll();
    }

    @GetMapping("skirts/{id}")
    public Skirt getSkirtById(@PathVariable int id) {
        return skirtsRepository.findById(id).get();

    }
}
