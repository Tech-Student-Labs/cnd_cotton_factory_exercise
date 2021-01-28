package com.cottonfactory.products.controllers.sweaters;

import com.cottonfactory.products.entities.Sweater;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SweaterIntTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("Test case to test the create sweater With size")
    public void testCreateSweaterWithSize() throws Exception {
        Sweater sweater = Sweater.builder()
                .type("pullover")
                .size("S")
                .customSize("40*20*5")
                .color("Blue")
                .longSleeve(true)
                .price(new BigDecimal(25.00)).build();
        mvc.perform(post("/api/products/sweater")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(sweater)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.type").value(sweater.getType()))
                .andExpect(jsonPath("$.sleeve").value(sweater.getSleeve()))
                .andExpect(jsonPath("$.neck").value(sweater.getNeck()))
                .andExpect(jsonPath("$.chest").value(sweater.getChest()))
                .andExpect(jsonPath("$.size").value(sweater.getSize()))
                .andExpect(jsonPath("$.customSize").value(sweater.getCustomSize()))
                .andExpect(jsonPath("$.color").value(sweater.getColor()))
                .andExpect(jsonPath("$.longSleeve").value(sweater.getLongSleeve()))
                .andExpect(jsonPath("$.price").value(sweater.getPrice()));
    }
}
