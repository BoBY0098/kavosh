package com.example.kavosh.controller;

import com.example.kavosh.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/action")
@RequiredArgsConstructor
public class ActionController {

    private final ActionService service;

    @GetMapping(value = "/runAction/{name}")
    public String runAction(@PathVariable String name) {
        service.performAction(name);
        return "Action " + name + " is being processed.";
    }
}
