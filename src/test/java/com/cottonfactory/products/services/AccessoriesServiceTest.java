package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Accessories;
import com.cottonfactory.products.repositories.AccessoriesRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class AccessoriesServiceTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    AccessoriesService accessoriesService;

    @Mock
    AccessoriesRepository accessoriesRepository;

    @Test
    public void testFetchAllAccessories(){

        List<Accessories> accessoriesListExpected = new ArrayList<>();
        Accessories accessories1 = new Accessories();
        accessories1.setId(1);
        accessories1.setType("belt");
        accessories1.setMaterial("'cotton'");
        accessories1.setColor("red");
        accessories1.setPrice(10.0);
        accessories1.setSize(10);
        accessoriesListExpected.add(accessories1);
        when(accessoriesRepository.findAll()).thenReturn(accessoriesListExpected);
        List<Accessories> accessoriesListActual = accessoriesService.getAllAccessories();
        Assert.assertNotNull(accessoriesListActual);
        Assert.assertNotNull(accessoriesListActual.get(0));
        Assert.assertEquals(accessoriesListExpected.get(0).getType(), accessoriesListActual.get(0).getType());
        Assert.assertEquals(accessoriesListExpected.get(0).getColor(), accessoriesListActual.get(0).getColor());
        Assert.assertEquals(accessoriesListExpected.get(0).getDesigner(), accessoriesListActual.get(0).getDesigner());
        Assert.assertEquals(accessoriesListExpected.get(0).getPrice(), accessoriesListActual.get(0).getPrice());
        Assert.assertEquals(accessoriesListExpected.get(0).getMaterial(), accessoriesListActual.get(0).getMaterial());
        Assert.assertEquals(accessoriesListExpected.get(0).getSize(), accessoriesListActual.get(0).getSize());
    }

}