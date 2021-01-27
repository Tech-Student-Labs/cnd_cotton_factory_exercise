package com.cottonfactory.products.controllers.pants;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PantsController_IntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllPants() throws Exception {
        mockMvc.perform(get("/api/products/pants"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].type").value("athletic"))
                .andExpect(jsonPath("$.[0].size").value("25"))
                .andExpect(jsonPath("$.[0].color").value("Grey"))
                .andExpect(jsonPath("$.[0].designer").value("Encoded"))
                .andExpect(jsonPath("$.[0].price").value(50.0));
    }
}
