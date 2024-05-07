package com.dance_scacpe_explorer.rythmcoders.Controller.Controller;

import com.dance.mo.Entities.*;
import com.dance.mo.Services.DancestudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DancestudyController {

    private final DancestudyService dancestudyService;

    @Autowired
    public DancestudyController(DancestudyService dancestudyService) {
        this.dancestudyService = dancestudyService;
    }

    // Endpoints for DanceSchool

    @GetMapping("/dance-schools")
    public List<DanceSchool> getAllDanceSchools() {
        return dancestudyService.getAllDanceSchools();
    }

    @GetMapping("/dance-schools/{id}")
    public DanceSchool getDanceSchoolById(@PathVariable Long id) {
        return dancestudyService.getDanceSchoolById(id);
    }

    @PostMapping("/dance-schools")
    public DanceSchool addDanceSchool(@RequestBody DanceSchool danceSchool) {
        return dancestudyService.addDanceSchool(danceSchool);
    }

    @PutMapping("/dance-schools/{id}")
    public DanceSchool updateDanceSchool(@PathVariable Long id, @RequestBody DanceSchool danceSchool) {
        return dancestudyService.updateDanceSchool(id, danceSchool);
    }

    @DeleteMapping("/dance-schools/{id}")
    public void deleteDanceSchool(@PathVariable Long id) {
        dancestudyService.deleteDanceSchool(id);
    }

    // Endpoints for Course

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return dancestudyService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return dancestudyService.getCourseById(id);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return dancestudyService.addCourse(course);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return dancestudyService.updateCourse(id, course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        dancestudyService.deleteCourse(id);
    }

    // Endpoints for DanceCategory

    @GetMapping("/dance-categories")
    public List<DanceCategory> getAllDanceCategories() {
        return dancestudyService.getAllDanceCategories();
    }

    @GetMapping("/dance-categories/{id}")
    public DanceCategory getDanceCategoryById(@PathVariable Long id) {
        return dancestudyService.getDanceCategoryById(id);
    }

    @PostMapping("/dance-categories")
    public DanceCategory addDanceCategory(@RequestBody DanceCategory danceCategory) {
        return dancestudyService.addDanceCategory(danceCategory);
    }

    @PutMapping("/dance-categories/{id}")
    public DanceCategory updateDanceCategory(@PathVariable Long id, @RequestBody DanceCategory danceCategory) {
        return dancestudyService.updateDanceCategory(id, danceCategory);
    }

    @DeleteMapping("/dance-categories/{id}")
    public void deleteDanceCategory(@PathVariable Long id) {
        dancestudyService.deleteDanceCategory(id);
    }

    // Endpoints for DanceStyle

    @GetMapping("/dance-styles")
    public List<DanceStyle> getAllDanceStyles() {
        return dancestudyService.getAllDanceStyles();
    }

    @GetMapping("/dance-styles/{id}")
    public DanceStyle getDanceStyleById(@PathVariable Long id) {
        return dancestudyService.getDanceStyleById(id);
    }

    @PostMapping("/dance-styles")
    public DanceStyle addDanceStyle(@RequestBody DanceStyle danceStyle) {
        return dancestudyService.addDanceStyle(danceStyle);
    }

    @PutMapping("/dance-styles/{id}")
    public DanceStyle updateDanceStyle(@PathVariable Long id, @RequestBody DanceStyle danceStyle) {
        return dancestudyService.updateDanceStyle(id, danceStyle);
    }

    @DeleteMapping("/dance-styles/{id}")
    public void deleteDanceStyle(@PathVariable Long id) {
        dancestudyService.deleteDanceStyle(id);
    }

    // Endpoints for Certification

    @GetMapping("/certifications")
    public List<Certification> getAllCertifications() {
        return dancestudyService.getAllCertifications();
    }

    @GetMapping("/certifications/{id}")
    public Certification getCertificationById(@PathVariable Long id) {
        return dancestudyService.getCertificationById(id);
    }

    @PostMapping("/certifications")
    public Certification addCertification(@RequestBody Certification certification) {
        return dancestudyService.addCertification(certification);
    }

    @PutMapping("/certifications/{id}")
    public Certification updateCertification(@PathVariable Long id, @RequestBody Certification certification) {
        return dancestudyService.updateCertification(id, certification);
    }
    // Endpoints for Quiz

    @GetMapping("/quizzes/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return dancestudyService.getQuizById(id);
    }

    @DeleteMapping("/certifications/{id}")
    public void deleteCertification(@PathVariable Long id) {
        dancestudyService.deleteCertification(id);
    }
    // Endpoints for Commentaire
    @GetMapping("/commentaires")
    public List<Commentaire> getAllCommentaires() {
        return dancestudyService.getAllCommentaires();
    }

    @PostMapping("/commentaires")
    public Commentaire addCommentaire(@RequestBody Commentaire commentaire) {
        return dancestudyService.addCommentaire(commentaire);
    }


}
