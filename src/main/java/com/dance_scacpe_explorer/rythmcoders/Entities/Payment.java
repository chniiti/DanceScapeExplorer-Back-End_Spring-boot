package com.dance_scacpe_explorer.rythmcoders.Entities;

import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.PaymentWay;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long paymentId;
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date dateOfPayment;
    @Enumerated(EnumType.STRING)
    private PaymentWay paymentWay;

    @OneToOne(mappedBy = "payment")
    private Ticket ticket;
}
