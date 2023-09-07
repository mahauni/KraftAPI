package br.com.ese.KraftAPI.controllers;

import br.com.ese.esgManager.database.DAO.ProfileDAO;
import br.com.ese.esgManager.javaBeans.jbProfile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @PostMapping
    public String insertProfile(@RequestBody jbProfile jbProfile) {
        try {
            ProfileDAO dao = new ProfileDAO();
            dao.insert(jbProfile);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Profile inserted with success!";
    }

    @DeleteMapping("/{id}")
    public String deleteProfile(@PathVariable String url) {
        try {
            ProfileDAO dao = new ProfileDAO();
            dao.deleteByUrl(url);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Profile Deleted with success!";
    }

    @PutMapping
    public String updateProfile(@RequestBody jbProfile jbProfile) {
        try {
            ProfileDAO dao = new ProfileDAO();
            dao.update(jbProfile);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return "Profile updated with success!";
    }

    @GetMapping("/{id}")
    public jbProfile getProfileByUrl(@PathVariable String url) {
        jbProfile problem = null;
        try {
            ProfileDAO dao = new ProfileDAO();
            problem = dao.selectByUrl(url);
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return problem;
    }

    @GetMapping
    public List<jbProfile> getProfile() {
        List<jbProfile> profiles= new ArrayList<>();
        try {
            ProfileDAO dao = new ProfileDAO();
            profiles = dao.selectAll();
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return profiles;
    }
}
