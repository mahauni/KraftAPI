package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.EsgDAO;
import br.com.ese.esgManager.javaBeans.jbESG;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/esg")
public class EsgController {

    @GetMapping
    public List<jbESG> getEsg() {
        List<jbESG> esgs = new ArrayList<>();

        try {
            EsgDAO dao = new EsgDAO();
            esgs = dao.selectAll();

        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return esgs;
    }
}
