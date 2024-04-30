package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DanceVenue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long danceVenueId;
    private String name;
<<<<<<< HEAD
    private String className;
=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    private int numberOfSeat;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    @OneToOne(mappedBy = "danceVenue")
    private Competition competition;
}
