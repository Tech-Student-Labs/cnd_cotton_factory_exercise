package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.ShoeProduct;
import com.cottonfactory.products.repositories.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    public void addShoeProduct(ShoeProduct shoeProduct){
        shoeRepository.save(shoeProduct);
    }
}
