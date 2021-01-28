package com.cottonfactory.products.controllers.sweater;

import com.cottonfactory.products.entities.sweater.Sweater;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class SweaterController {

    @PostMapping("/api/products/sweater")
    @ResponseStatus(HttpStatus.CREATED)
    public Sweater createSweater(@RequestBody Sweater sweater) {
        sweater.setId(1);
        return sweater;
    }
}
