package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ServiceSymbols;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/symbols")
public class ControllerSymbols {
    private static final Logger log = LoggerFactory.getLogger(ControllerSymbols.class);
    private final ServiceSymbols serviceSymbols;

    @PostMapping
    public String numberOfCharacters(@RequestBody String text) {
        log.info("Get string of symbols");
        return serviceSymbols.numberOfCharacters(text);
    }
}