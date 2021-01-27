package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Skirt;
import com.cottonfactory.products.repositories.SkirtsRepository;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SkirtsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SkirtsRepository skirtsRepository;

    @Test
    public void testGetAllSkirtsWithManyResults() throws Exception {
        when(skirtsRepository.findAll()).thenReturn(buildSkirtList(5));
        mockMvc.perform(get("/api/products/skirts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5))
                .andExpect(jsonPath("$[3].id").value(3));
    }

    private List<Skirt> buildSkirtList(int count){
        List<Skirt> skirts = new ArrayList<>();
        for(int i=0; i<count;i++){
            skirts.add(Skirt.builder()
                    .type("mini")
                    .id(i)
                    .build());
        }

        return skirts;
    }
}
