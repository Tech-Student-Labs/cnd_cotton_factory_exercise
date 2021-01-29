package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Slack;
import com.cottonfactory.products.services.SlackService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products/slacks")
@Api(tags = {"slacks"})
@AllArgsConstructor
public class SlackController {

    private SlackService slackService;

    @GetMapping
    public List<Slack> getAllSlacks() {
        return slackService.findAllSlacks();
    }

}
