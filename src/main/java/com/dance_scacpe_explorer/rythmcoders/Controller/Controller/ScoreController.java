package com.dance_scacpe_explorer.rythmcoders.Controller.Controller;

import com.dance.mo.Entities.AvisScore;
import com.dance.mo.Entities.Criterion;
import com.dance.mo.Entities.Score;
import com.dance.mo.Entities.User;
import com.dance.mo.Services.AvisScoreService;
import com.dance.mo.Services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private AvisScoreService avisScoreService;
    @PostMapping("/Addscore/{Firstname}/{Lastname}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Score Add(@RequestBody Criterion c , @PathVariable("Firstname")String Firstname , @PathVariable("Lastname")String Lastname) {
        return scoreService.saveScore(c,Firstname,Lastname);
    }

    @PostMapping("/UpdateScore/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Score Update(@RequestBody Criterion c , @PathVariable("id")Long id ) {
        return scoreService.updateScore(c,id);
    }

    @DeleteMapping("/DeleteScore/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void Delete(@PathVariable("id")Long id){
        scoreService.deleteScore(id);
    }

    @PostMapping("/scoreuser")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Score> scoreuser(@RequestBody User u){
        return scoreService.findbyuser(u);
    }
    @PostMapping("/feedback/{ids}/{idc}")
    @CrossOrigin(origins = "http://localhost:4200")
    public AvisScore avis(@RequestBody AvisScore a, @PathVariable("ids")Long ids, @PathVariable("idc")Long idc){
        return avisScoreService.add(a,ids,idc);
    }
    @PostMapping("/sendurl/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String send(@PathVariable("id")Long id,@RequestBody String url){
        avisScoreService.sendUrlAvis(id,url);
        return "ok";
    }

}
