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
<<<<<<< HEAD
    private boolean availability;
=======
    private String availability;
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;

    @OneToOne
    private Payment payment;

    @ManyToOne(cascade = CascadeType.ALL)
    private User buyer;
}
