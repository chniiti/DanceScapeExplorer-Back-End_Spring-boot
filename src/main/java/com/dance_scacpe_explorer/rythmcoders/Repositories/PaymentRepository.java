package com.dance_scacpe_explorer.rythmcoders.Repositories;

import com.dance_scacpe_explorer.rythmcoders.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Long, Payment> {
}
