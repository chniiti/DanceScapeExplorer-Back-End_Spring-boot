package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Criterion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String technique;
    private String artistry;
    private String choreography;
    private String performanceQuality;
    private String stagePresence;
    private String expressionAndEmotion;
    private String synchroAndPrecision;
}
