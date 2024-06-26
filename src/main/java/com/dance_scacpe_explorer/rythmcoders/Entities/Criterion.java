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
public class Criterion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String technique;
    private String artistry;
    private String choreography;
    private String performanceQuality;
    private String stagePresence;
    private String expressionAndEmotion;
    private String synchroAndPrecision;
    @OneToOne
    @JsonIgnore
    private Score score;
}
