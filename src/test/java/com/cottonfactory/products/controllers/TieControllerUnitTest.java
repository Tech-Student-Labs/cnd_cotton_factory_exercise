package com.cottonfactory.products.controllers;


import com.cottonfactory.products.entities.Tie;
import com.cottonfactory.products.services.TieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class TieControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    TieService mockService;

    @Test
    public void test_createTie() throws Exception {
        Tie tie = new Tie();
        tie.setId(1);
        tie.setColor("blue");
        tie.setMaterial("silk");
        tie.setType("bow tie");
        when(mockService.createTie(any())).thenReturn(tie);

        Tie tie2 = new Tie();
        tie2.setColor("blue");
        tie2.setMaterial("silk");
        tie2.setType("bow tie");
        mvc
                .perform(post("/api/products/ties")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(tie2)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.type").value(tie2.getType()))
                .andExpect(jsonPath("$.material").value(tie2.getMaterial()))
                .andExpect(jsonPath("$.color").value(tie2.getColor()))
        ;
    }
}
