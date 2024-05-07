package com.dance_scacpe_explorer.rythmcoders.Services;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
import com.dance_scacpe_explorer.rythmcoders.Entities.Evaluation;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public interface EvaluationService {
    Evaluation saveEvaluation(List<Long> idscores,Long idc , String Firstname , String Lastname);
    void deleteEvaluation(Long id);
    List<Evaluation> getAllEvaluations();
    Evaluation finbyid(Long id);
    List<Competition> allcompetion();
    void generateExcel(Competition competition,HttpServletResponse response) throws IOException;
    void importExcel(MultipartFile file, Long idc, String Firstname, String Lastname) throws IOException;

}
