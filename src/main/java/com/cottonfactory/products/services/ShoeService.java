package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.ShoeProduct;
import com.cottonfactory.products.repositories.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    public void addShoeProduct(ShoeProduct shoeProduct){
        shoeRepository.save(shoeProduct);
    }

    public List<ShoeProduct> getAllShoes() {

        return shoeRepository.findAll();
    }

    public ShoeProduct getShoeById(Long id) {

        return shoeRepository.findById(id).orElse(new ShoeProduct());
    }

    public void updateShoeProduct(ShoeProduct shoeProduct) {
        shoeRepository.save(shoeProduct);
    }
}
