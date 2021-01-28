package com.cottonfactory.products.controllers.sweaters;

import com.cottonfactory.products.controllers.sweater.SweaterController;
import com.cottonfactory.products.entities.sweater.Sweater;
import com.cottonfactory.products.services.sweater.SweaterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SweaterUnitTest {
    @MockBean
    Sweater sweater;

    @Mock
    SweaterService sweaterService;

    @Test
    public void createSweater(){

        when(sweaterService.createSweater(sweater)).thenReturn(sweater);

        SweaterController sweaterController = new SweaterController(sweaterService);

        Sweater sweaterFromController = sweaterController.createSweater(sweater);

        assertEquals(sweater, sweaterFromController);
        verify(sweaterService).createSweater(sweater);
    }
}