package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Slack;
import com.cottonfactory.products.repositories.SlackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SlackService {
    private SlackRepository slackRepository;

    public List<Slack> findAllSlacks() {
        return slackRepository.findAll();
    }

}
