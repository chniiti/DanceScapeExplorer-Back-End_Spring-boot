package com.dance_scacpe_explorer.rythmcoders.Services;

import com.dance_scacpe_explorer.rythmcoders.Entities.AvisScore;
import com.dance_scacpe_explorer.rythmcoders.Entities.Evaluation;
import com.dance_scacpe_explorer.rythmcoders.Entities.Score;
import com.dance_scacpe_explorer.rythmcoders.Repositories.AvisScoreRepo;
import com.dance_scacpe_explorer.rythmcoders.Repositories.EvaluationRepository;
import com.dance_scacpe_explorer.rythmcoders.Repositories.ScoreRepository;
import com.dance_scacpe_explorer.rythmcoders.Repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AvisScoreService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ScoreRepository ScoreRepository;
    @Autowired
    private EvaluationRepository EvaluationRepository;
    @Autowired
    private AvisScoreRepo avisScoreRepo;
    private JavaMailSender javaMailSender;

    public void sendUrlAvis(Long id,String url ) {
        Optional<Score>score=ScoreRepository.findById(id);
        if(score.isPresent()){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("kerkenisadok707@gmail.com");
            message.setTo(score.get().getParticipant().getEmail());
            message.setSubject("Danse Explore - FeedBack");
            String emailBody = """
        Hello Miss/ Sir,
        
        Here is the url to add your feedback """ + url + """
        
        Sincerely,
        Danse Explore 
        """;
            message.setText(emailBody);
            javaMailSender.send(message);
        }

    }

    public void send(String emailUser,String name,String nameuser,String text ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kerkenisadok707@gmail.com");
        message.setTo(emailUser);
        message.setSubject("Danse Explore - FeedBack");
        String emailBody = """
        Hello Miss/ Sir,
        
        We are here to announce to you that   """ + nameuser +"  Have added new feedback for the competition " +name+"   "+
                text+
              "  Sincerely  " +
                "Danse Explore";
            message.setText(emailBody);
            javaMailSender.send(message);
            }
    public AvisScore add(AvisScore a,Long ids,Long idc){
        Optional<Score>score=ScoreRepository.findById(ids);
        Optional<Evaluation>evaluation=EvaluationRepository.findById(idc);
        if(score.isPresent() && evaluation.isPresent()){
            a.setScore(score.get());
            a.setDate(new Date());
            this.send(evaluation.get().getJudge().getEmail(),evaluation.get().getCompetition().getName(),score.get().getParticipant().getFirstName()+score.get().getParticipant().getLastName(),a.getDescription());
            return avisScoreRepo.save(a);
        }
        return null;
    }
}
