package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Jacket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class JacketsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createJacket() throws Exception {

        Jacket jacket = new Jacket(
             "winter", "small","blue",
                true,"denim", new BigDecimal(50.0)
        );

        mockMvc.perform(post("/api/v1/products/jackets")
                        .content(toString(jacket))
                        .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.season").value("winter"))
                    .andExpect(jsonPath("$.size").value("small"))
                    .andExpect(jsonPath("$.color").value("blue"))
                    .andExpect(jsonPath("$.adultSize").value(true))
                    .andExpect(jsonPath("$.style").value("denim"))
                    .andExpect(jsonPath("$.price").value(50.0))
                    .andExpect(jsonPath("$.id").exists());

    }

     private String toString(Jacket jacket) throws JsonProcessingException {
        ObjectMapper mapper =  new ObjectMapper();
         return mapper.writeValueAsString(jacket);
     }

}
