package com.dance_scacpe_explorer.rythmcoders.Services;

import com.dance_scacpe_explorer.rythmcoders.Entities.*;
import com.dance_scacpe_explorer.rythmcoders.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CriterionRepository criterionRepository;
    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    @Transactional
    public Score saveScore( Criterion c , String Firstname , String Lastname) {
        Optional<User> u=userRepo.findByFirstNameAndAndLastName(Firstname,Lastname);
        if(u.isPresent()){
            Score score=new Score();
            score.setParticipant(u.get());
            score.setRank(0);
            score.setWinner(false);
            criterionRepository.save(c);
            int totalScore = calculateTotalScore(c);
            float normalizedScore = (float) totalScore / 7;
            score.setScore(normalizedScore);
            c.setScore(score);
            score.setCriterion(c);
            Score savedScore = scoreRepository.save(score);
            return savedScore;
        }
        return null;
    }

    @Override
    @Transactional
    public Score updateScore(Criterion c, Long id) {
        Optional<Score> optionalScore = scoreRepository.findById(id);
        if (optionalScore.isPresent()) {
            Score score = optionalScore.get();
            Optional<Criterion> optionalCriterion = criterionRepository.findById(c.getId());
            if (optionalCriterion.isPresent()) {
                c.setScore(score);
                criterionRepository.save(c);

                    score.setCriterion(c);
                    int totalScore = calculateTotalScore(c);
                    float normalizedScore = (float) totalScore / 7;
                    score.setScore(normalizedScore);
                    scoreRepository.save(score);

                Evaluation evaluation = score.getEvaluation();
                List<Score> scores = evaluation.getScores();
                scores.sort(Comparator.comparing(Score::getScore).reversed());
                for (int i = 0; i < scores.size(); i++) {
                    Score s = scores.get(i);
                    s.setRank(i + 1);
                    s.setWinner(i == 0);
                    scoreRepository.save(s);
                }
                return score;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    @Override
    public void deleteScore(Long id) {

        Optional<Score> optionalScore = scoreRepository.findById(id);
        if (optionalScore.isPresent()) {
            Score score = optionalScore.get();
            Long ide= score.getEvaluation().getId();
            scoreRepository.deleteById(id);
            Optional<Evaluation> evaluation=evaluationRepository.findById(ide);
            if (evaluation.isPresent()) {
                List<Score> scores = evaluation.get().getScores();
                scores.removeIf(scoree -> scoree.getId().equals(id));
                scores.sort(Comparator.comparing(Score::getScore).reversed());
                for (int i = 0; i < scores.size(); i++) {
                    Score s = scores.get(i);
                    s.setRank(i + 1);
                    s.setWinner(i == 0);
                    scoreRepository.save(s);
                }

            }

        }

    }

    @Override
    public List<Score> findbyuser(User u) {
      return scoreRepository.findByParticipant(u);
    }

    private int calculateTotalScore(Criterion c) {
        int totalScore = 0;
        totalScore += calculateScoreForCriterion(c.getTechnique());
        totalScore += calculateScoreForCriterion(c.getArtistry());
        totalScore += calculateScoreForCriterion(c.getChoreography());
        totalScore += calculateScoreForCriterion(c.getPerformanceQuality());
        totalScore += calculateScoreForCriterion(c.getStagePresence());
        totalScore += calculateScoreForCriterion(c.getExpressionAndEmotion());
        totalScore += calculateScoreForCriterion(c.getSynchroAndPrecision());
        return totalScore;
    }
    private int calculateScoreForCriterion(String value) {
        switch (value) {
            case "A":
                return 10;
            case "B":
                return 6;
            case "C":
                return 3;
            default:
                return 0;
        }
    }
}
