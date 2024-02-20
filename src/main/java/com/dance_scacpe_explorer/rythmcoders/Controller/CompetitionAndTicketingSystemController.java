package com.dance_scacpe_explorer.rythmcoders.Controller;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
import com.dance_scacpe_explorer.rythmcoders.Services.CompetitionAndTicketingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competitionAndTicketingSystem")
public class CompetitionAndTicketingSystemController {
    @Autowired
    CompetitionAndTicketingSystemService competitionAndTicketingSystemService;


}
