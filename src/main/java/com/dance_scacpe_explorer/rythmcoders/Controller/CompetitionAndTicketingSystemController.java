package com.dance_scacpe_explorer.rythmcoders.Controller;

import com.dance_scacpe_explorer.rythmcoders.Entities.*;
import com.dance_scacpe_explorer.rythmcoders.Services.CompetitionAndTicketingSystemService;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/CRUD")
@NoArgsConstructor
@Slf4j
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6

public class CompetitionAndTicketingSystemController {

    @Autowired
    CompetitionAndTicketingSystemService competitionAndTicketingSystemService;

<<<<<<< HEAD
    @PostMapping("/addCompetition")
    public ResponseEntity<Competition> addCompetition(@RequestBody Competition competition) {
        Competition addedCompetition = competitionAndTicketingSystemService.addCompetiton(competition);
        return ok(addedCompetition);
=======
    //Competition Controller
    @PostMapping("/addCompetition")
    public ResponseEntity<Competition> addCompetition(@RequestBody Competition competition) {
        Competition addedCompetition = competitionAndTicketingSystemService.addCompetiton(competition);
        return ResponseEntity.ok(addedCompetition);
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    }

    @GetMapping("/getCompetitionById/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable Long id) {
        Competition competition = competitionAndTicketingSystemService.getCompetitionById(id);
<<<<<<< HEAD
        return competition != null ? ok(competition) : ResponseEntity.notFound().build();
    }

    @GetMapping("/allCompetitions")
    public List<Competition> getAllCompetitions() {
=======
        if (competition != null) {
            return ResponseEntity.ok(competition);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allCompetitions")
    public List<Competition> getAllCompetition() {
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
        return competitionAndTicketingSystemService.getAllCompetition();
    }

    @DeleteMapping("/deleteCompetition/{id}")
    public ResponseEntity<String> deleteCompetition(@PathVariable Long id) {
        boolean isDeleted = competitionAndTicketingSystemService.deleteCompetition(id);
<<<<<<< HEAD
        return isDeleted ? ok("Competition deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competition not found");
=======
        if (isDeleted) {
            return ResponseEntity.ok("Competition deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competition not found");
        }
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    }

    @PutMapping("/updateCompetition/{id}")
    public ResponseEntity<String> updateCompetition(@PathVariable Long id, @RequestBody Competition updatedCompetition) {
        return competitionAndTicketingSystemService.updateCompetition(id, updatedCompetition);
    }

<<<<<<< HEAD
    @PostMapping("/join")
    public void joinCompetition(@RequestBody Competition competition,@RequestBody User participant){
         competitionAndTicketingSystemService.joinCompetition(competition, participant);
    }

    @PostMapping("/assignCtoD")
    public void assignCompetitionToADanceVenue(Long IdCompetition, Long IdDanceVenue){
        competitionAndTicketingSystemService.affectCompetitionToADanceVenue(IdCompetition,IdDanceVenue);
    }

    @GetMapping("/CompetitionByDanceVenue/{id}")
    public Competition getByDanceVenue(@PathVariable Long id){
        return competitionAndTicketingSystemService.getByDanceVenue(id);
    }

    //DanceVenue Controller
    @PostMapping("/addDanceVenue")
    public DanceVenue addDanceVenue(@RequestBody DanceVenue danceVenue) {
        return competitionAndTicketingSystemService.addDanceVenue(danceVenue);
    }

    @GetMapping("/getDanceVenueById/{id}")
    public ResponseEntity<DanceVenue> getDanceVenueById(@PathVariable Long id) {
        DanceVenue danceVenue = competitionAndTicketingSystemService.getDanceVenueById(id);
        return danceVenue != null ? ok(danceVenue) : ResponseEntity.notFound().build();
    }

    @GetMapping("/allDanceVenues")
    public List<DanceVenue> getAllDanceVenues() {
        return competitionAndTicketingSystemService.getAllDanceVenues();
    }

    @PutMapping("/updateDanceVenue/{id}")
    public ResponseEntity<String> updateDanceVenue(@PathVariable Long id, @RequestBody DanceVenue danceVenue) {
        return competitionAndTicketingSystemService.updateDanceVenue(id, danceVenue);
    }

    @DeleteMapping("/deleteDanceVenueById/{id}")
    public ResponseEntity<String> deleteDanceVenueById(@PathVariable Long id) {
        boolean isDeleted = competitionAndTicketingSystemService.deleteDanceVenue(id);
        return isDeleted ? ok("Dance venue deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dance venue not found");
    }

    //Multimedia controller

=======
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
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    @GetMapping("/getMultimedia")
    public List<Multimedia> getAllMultimedia(){
        return competitionAndTicketingSystemService.gelAllMultimedias();
    }

    @GetMapping("/MultimediaById/{id}")
    public ResponseEntity<Multimedia> getMultimediaById(@PathVariable Long id){
<<<<<<< HEAD
        Multimedia multimedia=competitionAndTicketingSystemService.getMultimediaById(id);
        if(multimedia!=null){
            return ok(multimedia);
=======
        Multimedia multimedia=competitionAndTicketingSystemService.getById(id);
        if(multimedia!=null){
            return ResponseEntity.ok(multimedia);
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
        }else{
            return ResponseEntity.notFound().build();
        }
    }
<<<<<<< HEAD






   /* @GetMapping( value = "CRUD/video/{title}", produces = "video/mp4")
    public Mono<Resource> streamContent(@PathVariable String title){
        Competition competition=new Competition();
        return competitionAndTicketingSystemService.retrieveContent(title, competition);
    }*/


    //Ticket controller
    /*@PostMapping("/addTicket")
=======
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
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
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
<<<<<<< HEAD
    }*/
=======
    }
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    @DeleteMapping("/deleteTicketById/{id}")
    public ResponseEntity<String> deleteTicketById(@PathVariable Long id){
        boolean isDeleted=competitionAndTicketingSystemService.deleteTicket(id);
        if(isDeleted){
<<<<<<< HEAD
            return ok("Ticket deleted successfully");
=======
            return ResponseEntity.ok("Ticket deleted successfully");
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
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
<<<<<<< HEAD
        return ok(payments);
=======
        return ResponseEntity.ok(payments);
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
    }
    @GetMapping("/addPaymentById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id){
        Payment payment=competitionAndTicketingSystemService.getPaymentById(id);
        if (payment!=null){
<<<<<<< HEAD
            return ok(payment);
=======
            return ResponseEntity.ok(payment);
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/findAllPayments")
    public List<Payment> getAllPayments(){
        return competitionAndTicketingSystemService.getAllPayment();
    }
<<<<<<< HEAD


    @PostMapping("/upload_video")
    public String uploadVideo(@RequestParam("file") MultipartFile file){
        competitionAndTicketingSystemService.uploadVideo(file);
        return "File uploaded successfully";
    }
    @PostMapping(value = "up", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, String>> handleFileUploadForm(@RequestPart("video") MultipartFile file) throws IOException {

        log.info("handling request parts: {}", file);

        try {

            File f = new ClassPathResource("").getFile();
            final Path path = Paths.get(f.getAbsolutePath() + File.separator + "static" + File.separator + "image");

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Path filePath = path.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/image/")
                    .path(file.getOriginalFilename())
                    .toUriString();

            var result = Map.of(
                    "filename", file.getOriginalFilename(),
                    "fileUri", fileUri
            );
            return ok().body(result);

        } catch (IOException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


=======
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6
}