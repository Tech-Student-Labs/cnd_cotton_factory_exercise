package com.cottonfactory.products.services;


import com.cottonfactory.products.entities.Tie;
import com.cottonfactory.products.repositories.TieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TieServiceUnitTest {


    private TieService service;


    private TieRepository mockTieRepository;

    @BeforeEach
    void init() {
        mockTieRepository = mock(TieRepository.class);
        service = new TieService(mockTieRepository);

    }


    @Test
    void createTie_test() {
        Tie tie = new Tie();
        tie.setColor("blue");
        tie.setMaterial("silk");
        tie.setType("bow tie");


        Tie mockTie = new Tie();
        mockTie.setId(1);
        mockTie.setColor("blue");
        mockTie.setMaterial("silk");
        mockTie.setType("bow tie");

        when(mockTieRepository.save(any())).thenReturn(mockTie);

       Tie actual =  service.createTie(tie);

        assertEquals(1,actual.getId());
        assertEquals(tie.getColor(), actual.getColor());
        assertEquals(tie.getMaterial(), actual.getMaterial());
        assertEquals(tie.getType(), actual.getType());
    }
}
