package com.bidance.bidance.entity;
import jakarta.persistence.*;

import java.util.List;





@Entity
public class DanceCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "danceCategory", cascade = CascadeType.ALL)
    private List<DanceStyle> danceStyles;

    // Constructeur
    public DanceCategory() {
    }

    // Constructeur avec champs
    public DanceCategory(String name, Course course, List<DanceStyle> danceStyles) {
        this.name = name;
        this.course = course;
        this.danceStyles = danceStyles;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<DanceStyle> getDanceStyles() {
        return danceStyles;
    }

    public void setDanceStyles(List<DanceStyle> danceStyles) {
        this.danceStyles = danceStyles;
    }
}
