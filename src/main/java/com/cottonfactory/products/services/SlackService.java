package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Slack;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlackService {
    public List<Slack> findAllSlacks() {
        return new ArrayList<>();
    }
}
