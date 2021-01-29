package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Skirt;
import com.cottonfactory.products.repositories.SkirtsRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
@Api(tags = "skirts")
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

    @PostMapping("skirts")
    @ResponseStatus(HttpStatus.CREATED)
    public Skirt addSkirt(@RequestBody Skirt skirt) {
        return skirtsRepository.save(skirt);
    }
}
