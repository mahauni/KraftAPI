package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.DepartmentDAO;
import br.com.ese.esgManager.javaBeans.jbAction;
import br.com.ese.esgManager.javaBeans.jbDepartment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @PostMapping
    public String insertDepartment(@RequestBody jbDepartment jbDepartment) {
        try {
            DepartmentDAO dao = new DepartmentDAO();
            dao.insert(jbDepartment);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Department inserted with success!";
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) {
        try {
            DepartmentDAO dao = new DepartmentDAO();
            dao.delete(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Department Deleted with success!";
    }

    @PutMapping
    public String updateDepartment(@RequestBody jbDepartment jbDepartment) {
        try {
            DepartmentDAO dao = new DepartmentDAO();
            dao.update(jbDepartment);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Department updated with success!";
    }

    @GetMapping("/{id}")
    public jbDepartment getDepartmentById(@PathVariable int id) {
        jbDepartment department = null;
        try {
            DepartmentDAO dao = new DepartmentDAO();
            department = dao.selectById(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return department;
    }

    @GetMapping
    @RequestMapping("/action")
    public List<jbAction> getActionsDepartment(@RequestBody jbDepartment jbDepartment) {
        List<jbAction> actions = new ArrayList<>();
        try {
            DepartmentDAO dao = new DepartmentDAO();
            actions = dao.getActions(jbDepartment);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return actions;
    }

    @GetMapping
    public List<jbDepartment> getDepartment() {
        List<jbDepartment> departments = new ArrayList<>();
        try {
            DepartmentDAO dao = new DepartmentDAO();
            departments = dao.selectAll();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return departments;
    }
}
