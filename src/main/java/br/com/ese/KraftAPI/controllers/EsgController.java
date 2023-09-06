package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.EsgDAO;
import br.com.ese.esgManager.javaBeans.jbESG;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public String postEsg(@RequestBody jbESG esg) {
        try {
            EsgDAO dao = new EsgDAO();
            dao.insert(esg);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return "ESG inserted with success!";
    }

    @DeleteMapping("/{id}")
    public String deleteEsg(@PathVariable int id) {
        try {
            EsgDAO dao = new EsgDAO();
            dao.delete(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return "ESG Deleted with success!";
    }

    @GetMapping("/{id}")
    public jbESG getEsgById(@PathVariable int id) {
        jbESG esg = null;
        try {
            EsgDAO dao = new EsgDAO();
            esg = dao.selectById(id);

        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return esg;
    }

    @PutMapping
    public String updateEsg(@RequestBody jbESG jbESG) {
        try {
            EsgDAO dao = new EsgDAO();
            dao.update(jbESG);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return "ESG updated with success!";
    }
}
