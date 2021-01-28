package com.cottonfactory.products.controllers.sweaters;

import com.cottonfactory.products.controllers.sweater.SweaterController;
import com.cottonfactory.products.entities.sweater.Sweater;
import com.cottonfactory.products.repositories.sweater.SweaterRepository;
import com.cottonfactory.products.services.sweater.SweaterService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SweaterUnitTest {


    @MockBean
    Sweater sweater;

    @MockBean
    SweaterService sweaterService;

    @Test
    public void createSweater(){
        Sweater sweaterFromService = new Sweater();
        assertNull(sweaterService);
        when(sweaterService.createSweater(sweater)).thenReturn(sweaterFromService);
        SweaterController sweaterController = new SweaterController(sweaterService);

        /*Sweater.builder()
                .type("pullover")
                .size("S")
                .customSize("40*20*5")
                .color("Blue")
                .longSleeve(true)
                .price(new BigDecimal(25.00)).build();*/


        /*Sweater.builder()
                .id(1)
                .type("pullover")
                .size("S")
                .customSize("40*20*5")
                .color("Blue")
                .longSleeve(true)
                .price(new BigDecimal(25.00)).build();*/

       //when(sweaterService.createSweater(sweater)).thenReturn(sweaterFromService);

        assertNull(sweater);
        Sweater sweaterFromController = sweaterController.createSweater(sweater);


        assertEquals(sweaterFromService, sweaterFromController);
        verify(sweaterService).createSweater(sweater);
    }








}
