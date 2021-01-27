package com.cottonfactory.products.controllers;

import com.cottonfactory.ProductApiHome;
import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.services.JacketService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@Api(tags = "jackets")
public class JacketController {

    private JacketService service;

    JacketController(JacketService service){
        this.service = service;
    }

    @PostMapping("/jackets")
    @ResponseStatus(value = HttpStatus.CREATED)
     Jacket createJacket(@RequestBody Jacket jacket){
        return service.createJacket(jacket);
    }


}
