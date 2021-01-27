package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.repositories.PantsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PantsService {

    public PantsService(PantsRepository pantsRepository) {
        this.pantsRepository = pantsRepository;
    }

    private PantsRepository pantsRepository;

    public List<Pants> findAllPants() {
        return pantsRepository.findAll();
    }
}
