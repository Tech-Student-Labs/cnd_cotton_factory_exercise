package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.DressEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Transactional
public class DressControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_getAllDress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/dress"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(0)));
    }
}
