package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.ProblemDAO;
import br.com.ese.esgManager.javaBeans.jbAction;
import br.com.ese.esgManager.javaBeans.jbProblem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @PostMapping
    public String insertProblem(@RequestBody jbProblem jbProblem) {
        try {
            ProblemDAO dao = new ProblemDAO();
            dao.insert(jbProblem);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Problem inserted with success!";
    }

    @DeleteMapping("/{id}")
    public String deleteProblem(@PathVariable int id) {
        try {
            ProblemDAO dao = new ProblemDAO();
            dao.delete(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Problem Deleted with success!";
    }

    @PutMapping
    public String updateProblem(@RequestBody jbProblem jbProblem) {
        try {
            ProblemDAO dao = new ProblemDAO();
            dao.update(jbProblem);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Problem updated with success!";
    }

    @GetMapping("/{id}")
    public jbProblem getProblemById(@PathVariable int id) {
        jbProblem problem = null;
        try {
            ProblemDAO dao = new ProblemDAO();
            problem = dao.selectById(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return problem;
    }

    @GetMapping
    public List<jbProblem> getProblem() {
        List<jbProblem> problems = new ArrayList<>();
        try {
            ProblemDAO dao = new ProblemDAO();
            problems = dao.selectAll();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return problems;
    }

    @GetMapping
    @RequestMapping("/problem")
    public List<jbAction> getActionProblem(@RequestBody jbProblem jbProblem) {
        List<jbAction> actions = new ArrayList<>();
        try {
            ProblemDAO dao = new ProblemDAO();
            actions = dao.getActions(jbProblem);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return actions;
    }
}
