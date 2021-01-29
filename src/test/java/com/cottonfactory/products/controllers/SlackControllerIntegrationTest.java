package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Slack;
import com.cottonfactory.products.repositories.SlackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class SlackControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SlackRepository slackRepository;

    @BeforeEach
    public void setUpDB() {
        slackRepository.deleteAll();
    }


    @Test
    public void test_getAllSlacks_return200_withDetailFound_excludingWaistInseam() throws Exception {
        Slack expectedSlack1 = Slack
                .builder()
                .type("formal")
                .waist(23)
                .inseam(30)
                .color("white")
                .designer("Encoded")
                .size("S")
                .price(BigDecimal.valueOf(23.00))
                .build();
        slackRepository.save(expectedSlack1);

        mockMvc.perform(get("/api/products/slacks"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].type").value("formal"))
                .andExpect(jsonPath("$[0].waist").doesNotExist())
                .andExpect(jsonPath("$[0].inseam").doesNotExist())
                .andExpect(jsonPath("$[0].color").value("white"))
                .andExpect(jsonPath("$[0].designer").value("Encoded"))
                .andExpect(jsonPath("$[0].size").value("S"))
                .andExpect(jsonPath("$[0].price").value(BigDecimal.valueOf(23.00)));
    }
}
