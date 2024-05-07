package com.dance_scacpe_explorer.rythmcoders.Entities;

import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private Role role;

    private String firstName;

    private String lastName;

    private Date birthday;

    private String email;

    private String password;

    private Integer phoneNumber;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<ForumPost> forumPosts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<ChatRoom> chatRooms;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    @JsonIgnore
    private  List<DanceSchool> danceSchools;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private List<Ticket> tickets;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "users")
    @JsonIgnore
    private List<Result> resultats;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Competition> competition;
    @OneToOne(mappedBy = "judge",cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JsonIgnore
    private Evaluation evaluations;
    @OneToMany(mappedBy = "participant",cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JsonIgnore
    private Set<Score> score;
}
