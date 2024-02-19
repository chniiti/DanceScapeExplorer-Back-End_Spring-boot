package com.bidance.bidance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DanceSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String position;
    private String horaire;

    @OneToMany(mappedBy = "danceSchool", cascade = CascadeType.ALL)
    private List<Course> courses;

    // Constructor
    public DanceSchool() {
    }

    // Constructor with fields
    public DanceSchool(String name, String position, String horaire, List<Course> courses) {
        this.name = name;
        this.position = position;
        this.horaire = horaire;
        this.courses = courses;
    }

    // Getters and Setters
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }







}
