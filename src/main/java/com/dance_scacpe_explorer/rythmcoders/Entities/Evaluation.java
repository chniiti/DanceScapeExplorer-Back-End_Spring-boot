package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evaluation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date evaluationDate;

    @OneToMany(mappedBy = "evaluation",cascade = CascadeType.REMOVE)
    private List<Score> scores;

    @OneToOne
    private User judge;
    @OneToOne
    private Competition competition;

}