package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Accessories;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class AccessoriesService {

    public List<Accessories> getAllAccessories(){
        return Arrays.asList(new Accessories());

    }
}
