package com.dance_scacpe_explorer.rythmcoders.Services;

<<<<<<< HEAD
import com.cloudinary.Cloudinary;
import com.dance_scacpe_explorer.rythmcoders.Entities.*;
import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.FileType;
import com.dance_scacpe_explorer.rythmcoders.Repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
=======
import com.dance_scacpe_explorer.rythmcoders.Entities.*;
import com.dance_scacpe_explorer.rythmcoders.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ClientInfoStatus;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
=======

import javax.swing.text.html.parser.Entity;
import java.util.List;
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
import java.util.Optional;

@Service
public class CompetitionAndTicketingSytemServiceImp implements CompetitionAndTicketingSystemService {

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
<<<<<<< HEAD
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private UploadRepository uploadRepository;

    private static final String FILE_PATH="file:///C:/Users/PC/Videos/%s.mp4";
=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6


    //Competition functions
    @Override
    public Competition addCompetiton(Competition competition) {
        return competitionRepository.save(competition);
    }

<<<<<<< HEAD

=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    @Override
    public Competition getCompetitionById(Long competitionId) {
        return competitionRepository.findById(competitionId).orElse(null);
    }

    @Override
    public List<Competition> getAllCompetition() {
        return competitionRepository.findAll();
    }

    @Override
    public boolean deleteCompetition(Long id) {
        Optional<Competition> competitionOptional = competitionRepository.findById(id);

        if (competitionOptional.isPresent()) {
            competitionRepository.delete(competitionOptional.get());
            return true; // Deletion successful
        } else {
            return false; // Competition not found
        }
    }

    @Override
    public ResponseEntity<String> updateCompetition(Long id, Competition updatedCompetition) {
        Optional<Competition> existingCompetition = competitionRepository.findById(id);
        if (existingCompetition.isPresent()) {
            Competition competition = existingCompetition.get();
            competition.setName(updatedCompetition.getName());
            competition.setDate(updatedCompetition.getDate());
            competition.setRules(updatedCompetition.getRules());

            competitionRepository.save(competition);
            return ResponseEntity.ok("competition updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("competition not found");
        }
    }

<<<<<<< HEAD
    @Override
    public void joinCompetition(Competition competition, User participant) {
        User LoggedInParticipant= userRepository.findById(participant.getUserId()).orElse(null);
        if(LoggedInParticipant==null){
            throw new IllegalArgumentException("Participant not found");
        }
        Competition existingCompetition=competitionRepository.findById(competition.getCompetitionId()).orElse(null);
        if(existingCompetition==null){
            throw new IllegalArgumentException("Competition not found");
        }
        //add user to the competition's list of participant
        List<User> participants=existingCompetition.getUserCompetition();
        participants.add(LoggedInParticipant);
        existingCompetition.setUserCompetition(participants);
        competitionRepository.save(existingCompetition);
    }

    @Override
    public void affectCompetitionToADanceVenue(Long IdCompetition, Long IdDanceVenue) {
        Competition c=competitionRepository.findById(IdCompetition).get();
        DanceVenue danceVenue=danceVenueRepository.findById(IdDanceVenue).get();
        c.setDanceVenue(danceVenue);
        competitionRepository.save(c);
    }

    @Override
    public Competition getByDanceVenue(Long danceVenueId) {
        return competitionRepository.getCompetitionByDanceVenue_DanceVenueId(danceVenueId);
    }

    // DanceVenue functions
=======
    //DanceVenue functions
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    @Override
    public DanceVenue addDanceVenue(DanceVenue danceVenue) {
        return danceVenueRepository.save(danceVenue);
    }
<<<<<<< HEAD

    @Override
    public DanceVenue getDanceVenueById(Long danceVenueId) {
        return danceVenueRepository.findById(danceVenueId).orElse(null);
    }

=======
    @Override
    public DanceVenue getDanceVenueById(Long DanceVenueId) {
        return danceVenueRepository.findById(DanceVenueId).orElse(null);
    }
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    @Override
    public List<DanceVenue> getAllDanceVenues() {
        return danceVenueRepository.findAll();
    }
<<<<<<< HEAD

=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    @Override
    public ResponseEntity<String> updateDanceVenue(Long id, DanceVenue updatedDanceVenue) {
        Optional<DanceVenue> existingDanceVenue = danceVenueRepository.findById(id);
        if (existingDanceVenue.isPresent()) {
            DanceVenue danceVenue = existingDanceVenue.get();
<<<<<<< HEAD
            danceVenue.setName(updatedDanceVenue.getName());
            danceVenue.setNumberOfSeat(updatedDanceVenue.getNumberOfSeat());

            danceVenueRepository.save(danceVenue);
            return ResponseEntity.ok("Dance venue updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dance venue not found");
        }
    }

    @Override
    public boolean deleteDanceVenue(Long id) {
        Optional<DanceVenue> danceVenueOptional = danceVenueRepository.findById(id);
        danceVenueOptional.ifPresent(danceVenueRepository::delete);
        return danceVenueOptional.isPresent();
    }

    //Multimedia functions


=======
            danceVenue.setName(danceVenue.getName());
            danceVenue.setNumberOfSeat((danceVenue.getNumberOfSeat()));

        danceVenueRepository.save(updatedDanceVenue);
        return ResponseEntity.ok("dance venue updated successfully");
    }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dance venue not found");
        }
    }
    @Override
    public boolean deleteDanceVenue(Long id) {
        Optional<DanceVenue> danceVenueOptional= danceVenueRepository.findById(id);
        if (danceVenueOptional.isPresent()){
            danceVenueRepository.delete(danceVenueOptional.get());
            return true;
        }else {
            return false;
        }
    }

    //Multimedia functions
    @Override
    public Multimedia addMultimedia(Multimedia multimedia) {
        return multimediaRepository.save(multimedia);
    }
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    @Override
    public List<Multimedia> gelAllMultimedias() {
        return multimediaRepository.findAll();
    }
    @Override
<<<<<<< HEAD
    public Multimedia getMultimediaById(Long multimediaId) {
        return multimediaRepository.findById(multimediaId).orElse(null);
    }
    @Override
    public void addMultimedia(Multimedia multimedia){
        multimediaRepository.save(multimedia);
    }
    @Override
    public void deleteMultimedia(Long id){
        multimediaRepository.deleteById(id);
    }


=======
    public Multimedia getById(Long multimediaId) {
        return multimediaRepository.findById(multimediaId).orElse(null);
    }

    @Override
    public ResponseEntity<String> updateMultimedia(Long id, Multimedia updatedMultimedia) {
        Optional<Multimedia> existingMultimedia=multimediaRepository.findById(id);
        if(existingMultimedia.isPresent()) {
            Multimedia multimedia = existingMultimedia.get();
            multimedia.setUploadDate(multimedia.getUploadDate());
            multimediaRepository.save(multimedia);
            return ResponseEntity.ok("Multimedia updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("you file not added");
        }
    }

    @Override
    public boolean deleteMultimedia(Long id) {
        Optional<Multimedia> multimediaOptional=multimediaRepository.findById(id);
        if(multimediaOptional.isPresent()){
            multimediaRepository.delete(multimediaOptional.get());
            return true;
        }else {
            return false;
        }
    }
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6

    //Ticket functions

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long TicketId) {
        return ticketRepository.findById(TicketId).orElse(null);
    }

    @Override
    public boolean deleteTicket(Long id) {
        Optional<Ticket> ticketOptional=ticketRepository.findById(id);
        if(ticketOptional.isPresent()){
            ticketRepository.delete(ticketOptional.get());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ResponseEntity<String> updateTiket(Long id, Ticket updatedTicket) {
        Optional<Ticket> ticketOptional=ticketRepository.findById(id);
        if (ticketOptional.isPresent()){
            Ticket ticket=ticketOptional.get();
            ticket.setTicketType(ticket.getTicketType());
            ticket.setPrice(ticket.getPrice());
            ticketRepository.save(ticket);
            return ResponseEntity.ok("updated successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found");
        }
    }

    //Payment functions

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long PaymentId) {
        return paymentRepository.findById(PaymentId).orElse(null);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public boolean deletPayment(Long id) {
        Optional<Payment> paymentOptional=paymentRepository.findById(id);
        if(paymentOptional.isPresent()){
            paymentRepository.delete(paymentOptional.get());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ResponseEntity<String> updatePayment(Long id, Payment updatedPayment) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if (paymentOptional.isPresent()) {
            Payment payment = paymentOptional.get();
            payment.setAmount(payment.getAmount());
            payment.setPaymentWay(payment.getPaymentWay());
            paymentRepository.save(payment);
            return ResponseEntity.ok("payment updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("payment not found");
        }
    }
<<<<<<< HEAD


    //Upload


    @Override
    @Transactional
    public void uploadVideo(MultipartFile file) {
        String filePath="C:/Users/PC/Desktop/uploads/"+file.getOriginalFilename();
        try{
            file.transferTo(new File(filePath));
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file");
        }

        Upload video=new Upload();
        video.setPath(filePath);
        video.setUploadDate(LocalDateTime.now());
        uploadRepository.save(video);
    }
=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
}