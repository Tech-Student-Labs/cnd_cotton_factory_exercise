package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.repositories.PantsRepository;
import com.cottonfactory.products.services.dtos.PantsDto;
import org.springframework.beans.BeanUtils;
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
            PantsDto pantsDto = getPantsDto(pants);
            return pantsDto;
        }).collect(Collectors.toList());
    }

    public PantsDto createNewPants(Pants pantsEntity) {
        pantsRepository.save(pantsEntity);
        PantsDto pantsDto = getPantsDto(pantsEntity);
        return pantsDto;
    }

    private PantsDto getPantsDto(Pants pantsEntity) {
        return new PantsDto(pantsEntity.getType(), pantsEntity.getSize(), pantsEntity.getColor(), pantsEntity.getDesigner(),
                pantsEntity.getPrice());
    }
}
