package com.dance_scacpe_explorer.rythmcoders.Repositories;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
<<<<<<< HEAD
import com.dance_scacpe_explorer.rythmcoders.Entities.DanceVenue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    boolean existsCompetitionByDateAndDanceVenue(Date date, DanceVenue danceVenue);

    Competition getCompetitionByDanceVenue_DanceVenueId(Long id);
=======
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
}
