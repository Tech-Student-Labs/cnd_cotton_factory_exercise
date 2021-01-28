package com.cottonfactory.products.controllers;

import com.cottonfactory.products.services.PantsService;
import com.cottonfactory.products.services.dtos.PantsDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/pants")
@Api(tags = {"pants"})
public class PantsController {

    @Autowired
    private PantsService pantsService;

    @GetMapping
    public List<PantsDto> getAllPants() {
        return pantsService.findAllPants();
    }
}
