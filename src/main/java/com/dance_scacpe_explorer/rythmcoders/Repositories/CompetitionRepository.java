package com.dance_scacpe_explorer.rythmcoders.Repositories;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Long, Competition> {
}
