package com.bidance.bidance.entity;


import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String instructor;
    private String schedule;
    @ManyToOne
    @JoinColumn(name = "dance_school_id") // Assuming the column name in Course table
    private DanceSchool danceSchool;

    // Constructeurs
    public Course() {
    }

    public Course(String name, String instructor, String schedule) {
        this.name = name;
        this.instructor = instructor;
        this.schedule = schedule;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
