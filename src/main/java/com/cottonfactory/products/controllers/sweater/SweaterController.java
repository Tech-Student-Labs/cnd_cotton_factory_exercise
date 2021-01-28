package com.cottonfactory.products.controllers.sweater;

import com.cottonfactory.products.entities.sweater.Sweater;
import com.cottonfactory.products.services.sweater.SweaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SweaterController {

    private SweaterService sweaterService;

    @Autowired
    public SweaterController(SweaterService sweaterService) {
        this.sweaterService = sweaterService;
    }

    @PostMapping("/api/products/sweater")
    @ResponseStatus(HttpStatus.CREATED)
    public Sweater createSweater(@RequestBody Sweater sweater) {
        Sweater sweater1= sweaterService.createSweater(sweater);
        return sweater1;
    }
}
