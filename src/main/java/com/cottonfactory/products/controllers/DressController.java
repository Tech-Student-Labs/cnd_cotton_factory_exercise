package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.DressEntity;
import com.cottonfactory.products.services.DressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Api(tags = {"dress"})
public class DressController {

    @Autowired
    private DressService dressService;

    @GetMapping("/dress")
    public List<DressEntity> getAllDress() {
        return dressService.getAllDress();
    }

    @PostMapping("/dress")
    @ResponseStatus(value = HttpStatus.CREATED)
    public DressEntity addDress(@RequestBody DressEntity dressEntity) {
        return dressService.addNewDress(dressEntity);
    }

}
