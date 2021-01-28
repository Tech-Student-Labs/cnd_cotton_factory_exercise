package com.cottonfactory.products.controllers;


import com.cottonfactory.products.entities.Tie;
import com.cottonfactory.products.services.TieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products/ties")
@Api(tags = {"ties"})
public class TieController {

    private TieService service;


    public TieController(TieService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tie createTie(@RequestBody Tie tie) {

            return service.createTie(tie);
    }


}
