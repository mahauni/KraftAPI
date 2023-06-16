package com.br.ese.KraftAPI.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class JsonController {

    @PostMapping
    public String json(@RequestBody String json) {
        return json;
    }
}
