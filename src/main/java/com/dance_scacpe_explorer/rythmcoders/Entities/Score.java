package com.dance_scacpe_explorer.rythmcoders.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float score;
    private int rank;
    private boolean winner;
    @ManyToOne
    private User participant;
    @OneToOne(mappedBy = "score",cascade = CascadeType.REMOVE)
    private Criterion criterion;

    @ManyToOne
    @JsonIgnore
    private Evaluation evaluation;
    @OneToOne(mappedBy = "score",cascade = CascadeType.ALL)
    private AvisScore avisScore;
}
