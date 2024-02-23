package com.dance_scacpe_explorer.rythmcoders.Controller;

import com.dance_scacpe_explorer.rythmcoders.Entities.*;
import com.dance_scacpe_explorer.rythmcoders.Services.CompetitionAndTicketingSystemService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor

public class CompetitionAndTicketingSystemController {

    @Autowired
    CompetitionAndTicketingSystemService competitionAndTicketingSystemService;

    //Competition Controller
    @PostMapping("/addCompetition")
    public ResponseEntity<Competition> addCompetition(@RequestBody Competition competition) {
        Competition addedCompetition = competitionAndTicketingSystemService.addCompetiton(competition);
        return ResponseEntity.ok(addedCompetition);
    }

    @GetMapping("/getCompetitionById/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable Long id) {
        Competition competition = competitionAndTicketingSystemService.getCompetitionById(id);
        if (competition != null) {
            return ResponseEntity.ok(competition);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allCompetitions")
    public List<Competition> getAllCompetition() {
        return competitionAndTicketingSystemService.getAllCompetition();
    }

    @DeleteMapping("/deleteCompetition/{id}")
    public ResponseEntity<String> deleteCompetition(@PathVariable Long id) {
        boolean isDeleted = competitionAndTicketingSystemService.deleteCompetition(id);
        if (isDeleted) {
            return ResponseEntity.ok("Competition deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competition not found");
        }
    }

    @PutMapping("/updateCompetition/{id}")
    public ResponseEntity<String> updateCompetition(@PathVariable Long id, @RequestBody Competition updatedCompetition) {
        return competitionAndTicketingSystemService.updateCompetition(id, updatedCompetition);
    }

    //DanceVenue Controller
    @PostMapping("/addDanceVenue")
    public ResponseEntity<DanceVenue> addDanceVenue(@RequestBody DanceVenue danceVenue) {
        DanceVenue addedSuccessfully = competitionAndTicketingSystemService.addDanceVenue(danceVenue);
        return ResponseEntity.ok(addedSuccessfully);
    }
    @GetMapping("/getDanceVenueById/{id}")
    public ResponseEntity<DanceVenue> getDanceVenueById(@PathVariable Long id){
        DanceVenue danceVenue= competitionAndTicketingSystemService.getDanceVenueById(id);
        if(danceVenue!=null){
            return ResponseEntity.ok(danceVenue);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/allDanceVenues")
    public List<DanceVenue> getAllDanceVenue(){
        return competitionAndTicketingSystemService.getAllDanceVenues();
    }
    @PutMapping("/updateDanceVenue/{id}")
    public ResponseEntity<String> updateDanceVenue(@PathVariable Long id, @RequestBody DanceVenue danceVenue){
        return competitionAndTicketingSystemService.updateDanceVenue(id, danceVenue);
    }
    @DeleteMapping("/DeleteDanceVenueById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean idDeleted=competitionAndTicketingSystemService.deleteDanceVenue(id);
        if (idDeleted){
            return ResponseEntity.ok("dance venue deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dance venue not found");
        }
    }

    //Multimedia controller
    @PostMapping("/addMultimedia")
    public ResponseEntity<Multimedia> addMultimedia (@RequestBody Multimedia multimedia){
        Multimedia addedMultimedia=competitionAndTicketingSystemService.addMultimedia(multimedia);
        return ResponseEntity.ok(addedMultimedia);
    }
    @GetMapping("/getMultimedia")
    public List<Multimedia> getAllMultimedia(){
        return competitionAndTicketingSystemService.gelAllMultimedias();
    }

    @GetMapping("/MultimediaById/{id}")
    public ResponseEntity<Multimedia> getMultimediaById(@PathVariable Long id){
        Multimedia multimedia=competitionAndTicketingSystemService.getById(id);
        if(multimedia!=null){
            return ResponseEntity.ok(multimedia);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("updateMultimediaById/{id}")
    public ResponseEntity<String> updateMultimedia(@PathVariable Long id, @RequestBody Multimedia updatedMultimedia){
        return competitionAndTicketingSystemService.updateMultimedia(id, updatedMultimedia);
    }
    @DeleteMapping("deleteMultimediaById/{id}")
    public ResponseEntity<String> deleteMultimediaById(@PathVariable Long id){
        boolean isDeleted=competitionAndTicketingSystemService.deleteMultimedia(id);
        if(isDeleted){
            return ResponseEntity.ok("Multimedia deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Multimedia not found");
        }
    }

    //Ticket controller
    @PostMapping("/addTicket")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        Ticket tickets=competitionAndTicketingSystemService.addTicket(ticket);
        return ResponseEntity.ok(tickets);
    }
    @GetMapping("/allTickets")
    public List<Ticket> getAllTickets(){
        return competitionAndTicketingSystemService.getAllTicket();
    }
    @GetMapping("/getTicketById/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id){
        Ticket ticket=competitionAndTicketingSystemService.getTicketById(id);
        if(ticket!=null){
            return ResponseEntity.ok(ticket);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deleteTicketById/{id}")
    public ResponseEntity<String> deleteTicketById(@PathVariable Long id){
        boolean isDeleted=competitionAndTicketingSystemService.deleteTicket(id);
        if(isDeleted){
            return ResponseEntity.ok("Ticket deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found");
        }
    }
    @PutMapping("/updateTicketById/{id}")
    private ResponseEntity<String> updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket){
        return competitionAndTicketingSystemService.updateTiket(id, updatedTicket);
    }

    //Payment controller
    @PostMapping("/addPayment")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
        Payment payments=competitionAndTicketingSystemService.addPayment(payment);
        return ResponseEntity.ok(payments);
    }
    @GetMapping("/addPaymentById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id){
        Payment payment=competitionAndTicketingSystemService.getPaymentById(id);
        if (payment!=null){
            return ResponseEntity.ok(payment);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/findAllPayments")
    public List<Payment> getAllPayments(){
        return competitionAndTicketingSystemService.getAllPayment();
    }
}