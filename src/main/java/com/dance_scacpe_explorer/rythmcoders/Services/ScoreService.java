package com.dance_scacpe_explorer.rythmcoders.Services;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
import com.dance_scacpe_explorer.rythmcoders.Entities.Criterion;
import com.dance_scacpe_explorer.rythmcoders.Entities.Score;
import com.dance_scacpe_explorer.rythmcoders.Entities.User;

import java.util.List;


public interface ScoreService {
    Score saveScore(Criterion c ,String Firstname , String Lastname);
    Score updateScore(Criterion c , Long id);
    void deleteScore(Long id);
    List<Score> findbyuser(User u);
}
