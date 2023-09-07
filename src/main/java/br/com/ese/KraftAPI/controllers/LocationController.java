package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.LocationDAO;
import br.com.ese.esgManager.javaBeans.jbLocation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @PostMapping
    public String insertLocation(@RequestBody jbLocation jbLocation) {
        try {
            LocationDAO dao = new LocationDAO();
            dao.insert(jbLocation);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Location inserted with success!";
    }

    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable int id) {
        try {
            LocationDAO dao = new LocationDAO();
            dao.delete(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Location Deleted with success!";
    }

    @PutMapping
    public String updateLocation(@RequestBody jbLocation jbLocation) {
        try {
            LocationDAO dao = new LocationDAO();
            dao.update(jbLocation);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Location updated with success!";
    }

    @GetMapping("/{id}")
    public jbLocation getLocationById(@PathVariable int id) {
        jbLocation location = null;
        try {
            LocationDAO dao = new LocationDAO();
            location = dao.selectById(id);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return location;
    }

    @GetMapping
    public List<jbLocation> getLocation() {
        List<jbLocation> locations = new ArrayList<>();
        try {
            LocationDAO dao = new LocationDAO();
            locations = dao.selectAll();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return locations;
    }
}
