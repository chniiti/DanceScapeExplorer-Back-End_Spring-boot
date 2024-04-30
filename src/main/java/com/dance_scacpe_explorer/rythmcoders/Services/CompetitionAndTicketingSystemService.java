package com.dance_scacpe_explorer.rythmcoders.Services;

<<<<<<< HEAD
import com.cloudinary.Cloudinary;
import com.dance_scacpe_explorer.rythmcoders.Entities.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;
import org.springframework.core.io.Resource;


=======
import com.dance_scacpe_explorer.rythmcoders.Entities.*;
import org.springframework.http.ResponseEntity;
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6

import javax.swing.event.ListDataEvent;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface CompetitionAndTicketingSystemService {
    //Competition functions
    public Competition addCompetiton (Competition competition);
    public Competition getCompetitionById(Long competitionId);
    public List<Competition> getAllCompetition();
    public boolean deleteCompetition(Long id);
    public ResponseEntity<String> updateCompetition(Long id, Competition updatedCompetition);
<<<<<<< HEAD
    public void joinCompetition (Competition competition, User participant);
    public void affectCompetitionToADanceVenue(Long IdCompetition, Long IdDanceVenue);


=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6

    //DanceVenue functions
    public DanceVenue addDanceVenue(DanceVenue danceVenue);
    public DanceVenue getDanceVenueById(Long DanceVenueId);
    public List<DanceVenue> getAllDanceVenues();
    public boolean deleteDanceVenue(Long id);
    public ResponseEntity<String> updateDanceVenue(Long id, DanceVenue updatedDanceVenue);

    //Multimedia functions
<<<<<<< HEAD

    void addMultimedia(Multimedia multimedia);
    Multimedia getMultimediaById(Long multimediaId);
    List<Multimedia> gelAllMultimedias();
    void  deleteMultimedia(Long id);

    Competition getByDanceVenue(Long danceVenueId);
=======
    Multimedia addMultimedia(Multimedia multimedia);
    Multimedia getById(Long multimediaId);
    List<Multimedia> gelAllMultimedias();
    boolean deleteMultimedia(Long id);
    public ResponseEntity<String> updateMultimedia(Long id, Multimedia updatedMultimedia);
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6

    //Ticket functions
    Ticket addTicket(Ticket ticket);
    Ticket getTicketById(Long TicketId);
    List<Ticket> getAllTicket();
    boolean deleteTicket(Long id);
    public ResponseEntity<String> updateTiket(Long id, Ticket updatedTicket);

    //Payment funtions
    Payment addPayment(Payment payment);
    Payment getPaymentById(Long PaymentId);
    List<Payment> getAllPayment();
    boolean deletPayment(Long id);
    public ResponseEntity<String> updatePayment(Long id, Payment updatedPayment);
<<<<<<< HEAD

    //Upload Video
    void uploadVideo(MultipartFile file);
=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
}
