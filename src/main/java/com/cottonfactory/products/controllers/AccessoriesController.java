
package com.cottonfactory.products.controllers;
import com.cottonfactory.products.entities.Accessories;
import com.cottonfactory.products.services.AccessoriesService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"accessories"})
public class AccessoriesController {


    private AccessoriesService accessoriesService;

    public AccessoriesController(AccessoriesService accessoriesService) {
        this.accessoriesService = accessoriesService;
    }

    @GetMapping("/api/products/accessories")
    @ResponseStatus(HttpStatus.OK)git
    public List<Accessories> getAllAccessories(){
        return accessoriesService.getAllAccessories();
    }
}