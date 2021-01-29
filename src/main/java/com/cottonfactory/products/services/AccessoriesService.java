package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Accessories;
import com.cottonfactory.products.repositories.AccessoriesRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class AccessoriesService {

    AccessoriesRepository accessoriesRepository;

    public AccessoriesService(AccessoriesRepository accessoriesRepository) {
        this.accessoriesRepository = accessoriesRepository;
    }

    public List<Accessories> getAllAccessories(){
        return accessoriesRepository.findAll();

    }
}
