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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

    @Test
    public void test_getAllShoes() throws Exception {
        test_Add_Shoe();
        mockMvc.perform(get("/api/products/shoe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].size").value(10))
                .andExpect(jsonPath("$[0].type").value("athletic"))
                .andExpect(jsonPath("$[0].height").value("normal"))
                .andExpect(jsonPath("$[0].material").value("leather"))
                .andExpect(jsonPath("$[0].designer").value("Encoded"))
                .andExpect(jsonPath("$[0].laced").value((true)))
                .andExpect(jsonPath("$[0].price").value(75.00));
    }

    @Test
    public void test_getShoeById() throws Exception {
        test_Add_Shoe();
        mockMvc.perform(get("/api/products/shoe/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.size").value(10))
                .andExpect(jsonPath("$.type").value("athletic"))
                .andExpect(jsonPath("$.height").value("normal"))
                .andExpect(jsonPath("$.material").value("leather"))
                .andExpect(jsonPath("$.designer").value("Encoded"))
                .andExpect(jsonPath("$.laced").value((true)))
                .andExpect(jsonPath("$.price").value(75.00));

    }

  }
