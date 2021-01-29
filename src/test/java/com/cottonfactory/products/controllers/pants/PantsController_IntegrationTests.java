package com.cottonfactory.products.controllers.pants;

import com.cottonfactory.products.entities.Pants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
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

    @Test
    public void createNewPants() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Pants pantsEntity = Pants.builder()
                .type("athletic")
                .inseam(25)
                .waist(25)
                .size("25")
                .color("Grey")
                .designer("Encoded")
                .price(BigDecimal.valueOf(50.0))
                .build();

        String content = objectMapper.writeValueAsString(pantsEntity);

        mockMvc.perform(post("/api/products/pants")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(content))
                .andExpect(status().isCreated());
    }
}
