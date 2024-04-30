package com.dance_scacpe_explorer.rythmcoders.Entities;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Competition implements Serializable {

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long competitionId;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String rules;
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    private int teamNumber;
    private String teamsName  ;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "competition")
    @JsonIgnore
    private Set<Ticket> tickets;

    @OneToOne

    private DanceVenue danceVenue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    @JsonIgnore
    private Set<Multimedia> multimedia;

    @ManyToMany
    @JsonIgnore
    private List<User> userCompetition;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    @JsonIgnore
    private List<DanceCategory> danceCategories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    @JsonIgnore
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long CompetitionId;
    private String Name;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String Rules;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "competition")
    private Set<Ticket> tickets;

    @OneToOne
    private DanceVenue danceVenue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private Set<Multimedia> multimedia;

    @ManyToMany
    private List<User> userCompetition;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
    private List<DanceCategory> danceCategories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competition")
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    private List<Feedback> feedback;


}
