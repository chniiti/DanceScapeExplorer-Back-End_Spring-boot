package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class DanceSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String position;
    private String horaire;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

<<<<<<< Updated upstream
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> users;
=======
    @ManyToMany(mappedBy = "danceSchools")
    private List<User> dsUsers;
>>>>>>> Stashed changes

}
