package com.cottonfactory.products.services;


import com.cottonfactory.products.entities.Tie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TieServiceUnitTest {


    private TieService service;

    @BeforeEach
    void init() {
        service = new TieService();
    }


    @Test
    void createTie_test() {
        Tie tie = new Tie();
        tie.setColor("blue");
        tie.setMaterial("silk");
        tie.setType("bow tie");

       Tie actual =  service.createTie(tie);

        assertNotNull(actual.getId());
        assertEquals(tie.getColor(), actual.getColor());
        assertEquals(tie.getMaterial(), actual.getMaterial());
        assertEquals(tie.getType(), actual.getType());
    }
}
