package com.dance_scacpe_explorer.rythmcoders.Entities;

import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.TicketType;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long TicketId;
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private double price;
    private String availability;

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;

    @ManyToOne(cascade = CascadeType.ALL)
    private DanceVenue danceVenue;

    @OneToOne
    private Payment payment;

    @ManyToOne
    private User buyer;
}
