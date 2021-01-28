package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.DressEntity;
import com.cottonfactory.products.repositories.DressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
public class DressControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired @Lazy
    private ObjectMapper mapper;

    @MockBean
    private DressRepository dressRepository;

    /**
     * Test for empty dress from the repository
     * @throws Exception
     */
    @Test
    public void test_getAllDress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/dress"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    /**
     * Test to get all the dress form the repository
     * @throws Exception
     */
    @Test
    public void test_getAllDressWithValues() throws Exception {
        when(dressRepository.findAll()).thenReturn(getAllDress());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/dress"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].type").value("tunic"));
    }

    /**
     * Util method to construct the Dress entity object.
     * @return
     */
    private List<DressEntity> getAllDress() {
        return List.of(DressEntity.builder().type("tunic").build());
    }
}

