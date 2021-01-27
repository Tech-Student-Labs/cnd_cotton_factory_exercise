package com.cottonfactory.products.services.sweater;

import com.cottonfactory.products.model.sweater.Sweater;
import com.cottonfactory.products.repositories.sweater.SweaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SweaterService {

    @Autowired
    private SweaterRepository sweaterRepository;
    public Sweater createSweater(Sweater sweater) {
       return sweaterRepository.save(sweater);
    }
}
