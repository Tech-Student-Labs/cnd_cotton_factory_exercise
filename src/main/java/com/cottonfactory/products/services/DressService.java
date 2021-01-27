package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.DressEntity;
import com.cottonfactory.products.repositories.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressService {

    @Autowired
    private DressRepository dressRepository;

    public List<DressEntity> getAllDress() {
        return dressRepository.findAll();
    }
}
