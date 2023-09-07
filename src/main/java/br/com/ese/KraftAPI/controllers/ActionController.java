package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.ActionDAO;
import br.com.ese.esgManager.javaBeans.jbAction;
import br.com.ese.esgManager.javaBeans.jbDepartment;
import br.com.ese.esgManager.javaBeans.jbProblem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionController {
    @PostMapping
    public String insertAction(@RequestBody jbAction jbAction) {
        try {
            ActionDAO dao = new ActionDAO();
            dao.insert(jbAction);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return "Action inserted with success!";
    }

    @DeleteMapping("/{id}")
    public String deleteAction(@PathVariable int id) {
        try {
            ActionDAO dao = new ActionDAO();
            dao.delete(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return "Action Deleted with success!";
    }

    @PutMapping
    public String updateAction(@RequestBody jbAction jbAction) {
        try {
            ActionDAO dao = new ActionDAO();
            dao.update(jbAction);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return "Action updated with success!";
    }

    @GetMapping("/{id}")
    public jbAction getActionById(@PathVariable int id) {
        jbAction esg = null;
        try {
            ActionDAO dao = new ActionDAO();
            esg = dao.selectById(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return esg;
    }

    @GetMapping
    @RequestMapping("/problem")
    public List<jbProblem> getProblemsAffected(@RequestBody jbAction jbAction) {
        List<jbProblem> problems = new ArrayList<>();
        try {
            ActionDAO dao = new ActionDAO();
            problems = dao.getProblemsAffected(jbAction);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return problems;
    }

    @GetMapping
    @RequestMapping("/department")
    public List<jbDepartment> getResponsibilities(@RequestBody jbAction jbAction) {
        List<jbDepartment> departments = new ArrayList<>();
        try {
            ActionDAO dao = new ActionDAO();
            departments = dao.getResponsibles(jbAction);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return departments;
    }

    @GetMapping
    public List<jbAction> getAction() {
        List<jbAction> actions = new ArrayList<>();
        try {
            ActionDAO dao = new ActionDAO();
            actions = dao.selectAll();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return actions;
    }
}
