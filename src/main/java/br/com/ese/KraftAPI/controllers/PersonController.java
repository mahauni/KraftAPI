package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.PersonDAO;
import br.com.ese.esgManager.javaBeans.jbPerson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @PostMapping
    public String insertPerson(@RequestBody jbPerson jbPerson) {
        try {
            PersonDAO dao = new PersonDAO();
            dao.insert(jbPerson);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Person inserted with success!";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable int id) {
        try {
            PersonDAO dao = new PersonDAO();
            dao.delete(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Person Deleted with success!";
    }

    @PutMapping
    public String updatePerson(@RequestBody jbPerson jbPerson) {
        try {
            PersonDAO dao = new PersonDAO();
            dao.update(jbPerson);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Person updated with success!";
    }

    @GetMapping("/{id}")
    public jbPerson getPersonById(@PathVariable int id) {
        jbPerson person = null;
        try {
            PersonDAO dao = new PersonDAO();
            person = dao.selectById(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return person;
    }

    @GetMapping
    public List<jbPerson> getPerson() {
        List<jbPerson> persons = new ArrayList<>();
        try {
            PersonDAO dao = new PersonDAO();
            persons = dao.selectAll();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return persons;
    }
}
