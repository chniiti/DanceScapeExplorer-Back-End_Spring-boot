package com.dance_scacpe_explorer.rythmcoders.Entities;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Competition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long CompetitionId;
    private String Name;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String Rules;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    @OneToOne
    private DanceVenue danceVenue;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Multimedia> multimedia;

    @ManyToMany(mappedBy = "competition")
    private Set<User> user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DanceCategory> danceCategories;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Feedback> feedback;
    @OneToOne(mappedBy = "competition",cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JsonIgnore
    private Evaluation evaluation;

}
