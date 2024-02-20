package com.dance_scacpe_explorer.rythmcoders.Services;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
import com.dance_scacpe_explorer.rythmcoders.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionAndTicketingSytemServiceImp implements CompetitionAndTicketingSystemService{
    @Autowired
    CompetitionRepository competitionRepository;
    @Autowired
    DanceVenueRepository danceVenueRepository;
    @Autowired
    MultimediaRepository multimediaRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Competition addCompetiton(Competition competition) {
        return competitionRepository.save(competition);
    }
}
