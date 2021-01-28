package com.cottonfactory.products.services;

import com.cottonfactory.products.repositories.PantsRepository;
import com.cottonfactory.products.services.dtos.PantsDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PantsService {

    public PantsService(PantsRepository pantsRepository) {
        this.pantsRepository = pantsRepository;
    }

    private PantsRepository pantsRepository;

    public List<PantsDto> findAllPants() {
        return pantsRepository.findAll().stream().map(pants -> {
            PantsDto pantsDto =
                    new PantsDto(pants.getType(), pants.getSize(), pants.getColor(), pants.getDesigner(),
                            pants.getPrice());
            return pantsDto;
        }).collect(Collectors.toList());
    }
}
