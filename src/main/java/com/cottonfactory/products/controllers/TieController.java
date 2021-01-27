package com.cottonfactory.products.controllers;


import com.cottonfactory.products.entities.Tie;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products/ties")
@Api(tags = {"ties"})
public class TieController {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tie createTie(@RequestBody Tie tie) {
            tie.setId(1);
            return tie;
    }


}
