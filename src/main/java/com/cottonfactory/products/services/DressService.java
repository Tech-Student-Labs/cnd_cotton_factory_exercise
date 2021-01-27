package com.cottonfactory.products.services;

import com.cottonfactory.products.repositories.DressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DressService {

    @Autowired
    private DressRepository dressRepository;
}
