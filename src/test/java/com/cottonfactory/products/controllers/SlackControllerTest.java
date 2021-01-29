package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Slack;
import com.cottonfactory.products.services.SlackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SlackController.class)
public class SlackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SlackService slackService;

    @Test
    public void test_getAllSlacks_return200_withDetailFound_excludingWaistInseam() throws Exception {
        Slack expectedSlack = Slack
                .builder()
                .type("formal")
                .build();
        when(slackService.findAllSlacks()).thenReturn(Arrays.asList(expectedSlack));

        mockMvc.perform(get("/api/products/slacks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0]").value(expectedSlack))
                .andExpect(jsonPath("$[0].inseam").doesNotExist())
                .andExpect(jsonPath("$[0].waist").doesNotExist());
    }

}
