package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.repositories.PantsRepository;
import com.cottonfactory.products.services.dtos.PantsDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PantsServiceTest {

    @Test
    public void createNewPants() {
        PantsRepository mockPantsRepository = mock(PantsRepository.class);
        PantsService pantsService = new PantsService(mockPantsRepository);

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

        assertEquals(expectedPantsDto,actualPantsDto);

    }


}
