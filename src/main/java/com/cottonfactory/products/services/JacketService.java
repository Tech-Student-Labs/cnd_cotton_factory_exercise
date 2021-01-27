package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.repositories.JacketRepository;
import org.springframework.stereotype.Service;

@Service
public class JacketService {

    private JacketRepository repository;

    JacketService(JacketRepository repository){
        this.repository = repository;
    }

    public Jacket createJacket(Jacket jacket){
        return repository.save(jacket);
    }

}
