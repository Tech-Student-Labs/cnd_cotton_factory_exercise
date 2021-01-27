package com.cottonfactory.products.services;


import com.cottonfactory.products.entities.Slack;
import com.cottonfactory.products.repositories.SlackRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SlackServiceTest {

    @InjectMocks
    private SlackService slackService;

    @Mock
    private SlackRepository slackRepository;

    @Test
    public void test_findAll_returnEmptylist_whenNoSlackFound() {
        when(slackRepository.findAll()).thenReturn(new ArrayList<>());
        assertEquals(0, slackService.findAll().size());
    }

    @Test
    public void test_findAll_returnAllSlacks() {
        Slack expectedSlack = Slack
                .builder()
                .type("formal")
                .build();
        when(slackRepository.findAll()).thenReturn(Arrays.asList(expectedSlack));
        assertTrue( slackService.findAll().size() > 0);
    }
}
