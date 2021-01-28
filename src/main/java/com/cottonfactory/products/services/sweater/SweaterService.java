package com.cottonfactory.products.services.sweater;

import com.cottonfactory.products.entities.sweater.Sweater;
import com.cottonfactory.products.repositories.sweater.SweaterRepository;
import org.springframework.stereotype.Service;

@Service
public class SweaterService {

    private SweaterRepository sweaterRepository;

    public SweaterService(){

    }

    public SweaterService(SweaterRepository sweaterRepository) {
        this.sweaterRepository = sweaterRepository;
    }

    public Sweater createSweater(Sweater sweater) {
       return sweaterRepository.save(sweater);
    }
}
