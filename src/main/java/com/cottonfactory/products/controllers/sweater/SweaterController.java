package com.cottonfactory.products.controllers.sweater;

import com.cottonfactory.products.exception.sweater.InvalidSweaterException;
import com.cottonfactory.products.model.sweater.Sweater;
import com.cottonfactory.products.services.sweater.SweaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SweaterController {

    @Autowired
    private SweaterService sweaterService;

    @PostMapping("/api/products/sweater")
    @ResponseStatus(HttpStatus.CREATED)
    public Sweater createSweater(@RequestBody Sweater sweater) throws InvalidSweaterException {
        if(sweater.getSize()!=null && (sweater.getSleeve()!=null || sweater.getNeck()!=null || sweater.getChest()!=null)){
            throw new InvalidSweaterException("Invalid Sweater size details");
        }
        return sweaterService.createSweater(sweater);
    }
}
