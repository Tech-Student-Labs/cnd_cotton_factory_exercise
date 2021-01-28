package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.ShoeProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShoeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;




/*
come in the following types: heels, athletic, boot, sandal
come in the following heights: normal, ankle, knee
can be these materials: canvas, leather, rubber
designer options: Encoded, Footsy, Stepper Leper
 */

    @Test
    public void test_Add_Shoe() throws Exception {
        ShoeProduct shoeProduct = ShoeProduct.builder()
                .material("leather")
                .type("athletic")
                .height("normal")
                .designer("Encoded")
                .laced(true)
                .size(10)
                .price(new BigDecimal(75.00))
                .build();

        mockMvc.perform(post("/api/products/shoe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(shoeProduct)))
                .andExpect(status().isCreated());

    }

}
