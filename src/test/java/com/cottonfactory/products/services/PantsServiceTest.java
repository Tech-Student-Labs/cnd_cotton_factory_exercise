package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.repositories.PantsRepository;
import com.cottonfactory.products.services.dtos.PantsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PantsServiceTest {

    PantsRepository mockPantsRepository;

    PantsService pantsService;

    @BeforeEach
    private void setUp() {
        mockPantsRepository = mock(PantsRepository.class);
        pantsService = new PantsService(mockPantsRepository);
    }

    @Test
    public void createNewPants() {
        Pants pantsEntity = Pants.builder()
                .type("athletic")
                .inseam(25)
                .waist(25)
                .size("25")
                .color("Grey")
                .designer("Encoded")
                .price(BigDecimal.valueOf(50.0))
                .build();

        when(mockPantsRepository.save(pantsEntity)).thenReturn(pantsEntity);

        PantsDto expectedPantsDto = PantsDto.builder()
                .type("athletic")
                .size("25")
                .color("Grey")
                .designer("Encoded")
                .price(BigDecimal.valueOf(50.0))
                .build();

        PantsDto actualPantsDto = pantsService.createNewPants(pantsEntity);

        assertEquals(expectedPantsDto, actualPantsDto);

    }

    @Test
    public void getPantsByProductId() {

        Pants pantsEntity = Pants.builder()
                .id(1)
                .type("athletic")
                .inseam(25)
                .waist(25)
                .size("25")
                .color("Grey")
                .designer("Encoded")
                .price(BigDecimal.valueOf(50.0))
                .build();
        when(mockPantsRepository.getOne(any())).thenReturn(pantsEntity);

        PantsDto expectedPantsDto = PantsDto.builder()
                .type("athletic")
                .size("25")
                .color("Grey")
                .designer("Encoded")
                .price(BigDecimal.valueOf(50.0))
                .build();

        PantsDto actualPantsDTO = pantsService.getPantsByProductId(1L);

         assertEquals(expectedPantsDto,actualPantsDTO);


    }




}
