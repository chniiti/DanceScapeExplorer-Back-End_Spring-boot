package com.dance_scacpe_explorer.rythmcoders.Repositories;

import com.dance_scacpe_explorer.rythmcoders.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Long, Ticket> {
}
