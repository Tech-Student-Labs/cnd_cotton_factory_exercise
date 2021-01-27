package com.cottonfactory.products.controllers;


import com.cottonfactory.products.entities.Tie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class TieControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void test_createTie() throws Exception {
        Tie tie = new Tie();
        tie.setColor("blue");
        tie.setMaterial("silk");
        tie.setType("bow tie");

        mvc
                .perform(post("/api/products/ties")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(tie)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.type").value(tie.getType()))
                .andExpect(jsonPath("$.material").value(tie.getMaterial()))
                .andExpect(jsonPath("$.color").value(tie.getColor()))
        ;
    }
}
