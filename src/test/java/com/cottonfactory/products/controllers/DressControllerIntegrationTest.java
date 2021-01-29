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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class DressControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @Lazy
    private ObjectMapper mapper;

    @MockBean
    private DressRepository dressRepository;

    /**
     * Test for empty dress from the repository
     *
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
     *
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
     * Test to get all the dress from the repository
     *
     * @throws Exception
     */
    @Test
    public void test_addDress() throws Exception {
        when(dressRepository.save(addDress())).thenReturn(addDress());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/products/dress")
                .content(mapper.writeValueAsString(addDress())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id",is(0)))
                .andExpect(jsonPath("$.type").value("tunic"));
    }

    /**
     * Util method to construct the Dress entity object.
     *
     * @return
     */
    private DressEntity addDress() {
        return DressEntity.builder().type("tunic").build();
    }


    /**
     * Util method to construct the Dress entity objects.
     *
     * @return
     */
    private List<DressEntity> getAllDress() {
        return List.of(DressEntity.builder().type("tunic").build());
    }
}

