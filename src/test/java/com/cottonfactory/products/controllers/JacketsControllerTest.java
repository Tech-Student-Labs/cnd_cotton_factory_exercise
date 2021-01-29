package com.cottonfactory.products.controllers;

import com.cottonfactory.ProductConstants;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class JacketsControllerTest {

    @Autowired
    MockMvc mockMvc;

    
	/* Update to response structure
	 * { "data":{ "id":1, "size":"" }, "errors":[
	 * {"message":"Invalid value for season."},
	 * {"message":"Invalid value for size."} ] }
	 */
    @Test
    public void createJacket() throws Exception {

        Jacket jacket = new Jacket(
             "winter", "small","blue",
                true,"denim", new BigDecimal(50.0)
        );

        mockMvc.perform(post("/api/products/jackets")
                        .content(toString(jacket))
                        .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.data.season").value("winter"))
                    .andExpect(jsonPath("$.data.size").value("small"))
                    .andExpect(jsonPath("$.data.color").value("blue"))
                    .andExpect(jsonPath("$.data.adultSize").value(true))
                    .andExpect(jsonPath("$.data.style").value("denim"))
                    .andExpect(jsonPath("$.data.price").value(50.0))                   
                    .andExpect(jsonPath("$.data.id").exists())
                    .andExpect(jsonPath("$.errors").isEmpty());

    }   

    @Test
    public void createJacket_FailForValidation() throws Exception {
    	Jacket jacket = new Jacket(
                "random", "invalid","blue",
                   true,"satin", new BigDecimal(50.0)
           );
    	
    	mockMvc.perform(post("/api/products/jackets")
                .content(toString(jacket))
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.data").doesNotExist())
            .andExpect(jsonPath("$.errors").exists())
            .andExpect(jsonPath("$.errors.length()").value(3));
          
    }

     private String toString(Jacket jacket) throws JsonProcessingException {
        ObjectMapper mapper =  new ObjectMapper();
         return mapper.writeValueAsString(jacket);
     }

}
