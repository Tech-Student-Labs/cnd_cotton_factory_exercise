package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Sweater;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Api
public class SweaterController {

    @PostMapping("/api/products/sweater")
    @ResponseStatus(HttpStatus.CREATED)
    public Sweater createSweater(@RequestBody Sweater sweater) {
        Sweater returnSweater = Sweater.builder()
                .id(1)
                .type(sweater.getType())
                .color(sweater.getColor())
                .longSleeve(sweater.getLongSleeve())
                .price(sweater.getPrice()).build();
        if ((null != sweater.getSize())) {
            returnSweater.setSize(sweater.getSize());
        } else {
            returnSweater.setCustomSize(sweater.getCustomSize());
        }
        return returnSweater;
    }
}
