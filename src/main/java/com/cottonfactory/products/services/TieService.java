package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Tie;
import com.cottonfactory.products.repositories.TieRepository;
import org.springframework.stereotype.Service;

@Service
public class TieService {

    private TieRepository tieRepository;

    public TieService(TieRepository tieRepository) {
        this.tieRepository = tieRepository;
    }

    public Tie createTie(Tie tie) {
        return tieRepository.save(tie);
    }
}
