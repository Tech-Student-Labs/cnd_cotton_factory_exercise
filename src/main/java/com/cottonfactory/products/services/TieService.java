package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Tie;
import org.springframework.stereotype.Service;

@Service
public class TieService {


    public Tie createTie(Tie tie) {
        return new Tie();
    }
}
