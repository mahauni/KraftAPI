package br.com.ese.KraftAPI.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/json")
public class JsonController {

    @PostMapping
    public String json(@RequestBody String json) {
        return json;
    }

}
