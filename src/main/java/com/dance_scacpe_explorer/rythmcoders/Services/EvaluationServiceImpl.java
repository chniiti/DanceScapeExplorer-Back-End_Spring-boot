package com.dance_scacpe_explorer.rythmcoders.Services;

import com.dance_scacpe_explorer.rythmcoders.Entities.*;
import com.dance_scacpe_explorer.rythmcoders.Repositories.*;
import com.dance_scacpe_explorer.rythmcoders.Repositories.EvaluationRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private ScoreServiceImpl scoreService;


    @Override
    public Evaluation saveEvaluation(List<Long> idscores, Long idc, String Firstname, String Lastname) {
        Optional<User> u = userRepo.findByFirstNameAndAndLastName(Firstname, Lastname);
        Optional<Competition> c = competitionRepository.findById(idc);
        if (u.isPresent() && c.isPresent()) {
            Evaluation e = new Evaluation();
            List<Score> scs =new ArrayList<>();
            e.setEvaluationDate(new Date());
            e.setJudge(u.get());
            e.setCompetition(c.get());
            Evaluation savedevauation=evaluationRepository.save(e);
            for (int i = 0; i < idscores.size(); i++) {
                Long id = idscores.get(i);
                Optional<Score> score= scoreRepository.findById(id);
                if (score.isPresent()) {
                    score.get().setEvaluation(savedevauation);
                    scoreRepository.save(score.get());
                    scs.add(score.get());
                }
            }
            List<Score> scores =scs;
            scores.sort(Comparator.comparing(Score::getScore).reversed());
            for (int i = 0; i < scores.size(); i++) {
                Score score = scores.get(i);
                score.setRank(i + 1);
                score.setWinner(i == 0);
                scoreRepository.save(score);
            }

            return savedevauation;
        }
        return new Evaluation();
    }

    @Override
    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public List<Competition> allcompetion() {
        return competitionRepository.findAll();
    }

    @Override
    public void generateExcel(Competition competition,HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Competition");


        Row headerRow = sheet.createRow(0);
        String[] columns = {"firstname", "lastname", "technique", "artistry", "choreography",
                "performanceQuality", "stagePresence", "expressionAndEmotion",
                "synchroAndPrecision"};

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int rowNum = 1;
        for (User user : competition.getUser()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getFirstName());
            row.createCell(1).setCellValue(user.getLastName());


        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }

    @Override
    public void importExcel(MultipartFile file, Long idc, String Firstname, String Lastname) throws IOException {
        List<Long> ids=new ArrayList<>();

        try (InputStream inputStream = file.getInputStream()) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Criterion f = new Criterion();
                if (row.getRowNum() == 0) {
                    continue;
                }

                String firstName = row.getCell(0).getStringCellValue();
                String lastName = row.getCell(1).getStringCellValue();
                String technique = row.getCell(2).getStringCellValue();
                String artistry = row.getCell(3).getStringCellValue();
                String choreography = row.getCell(4).getStringCellValue();
                String performanceQuality = row.getCell(5).getStringCellValue();
                String stagePresence = row.getCell(6).getStringCellValue();
                String expressionAndEmotion = row.getCell(7).getStringCellValue();
                String synchroAndPrecision = row.getCell(8).getStringCellValue();
                f.setArtistry(artistry);
                f.setChoreography(choreography);
                f.setTechnique(technique);
                f.setPerformanceQuality(performanceQuality);
                f.setStagePresence(stagePresence);
                f.setExpressionAndEmotion(expressionAndEmotion);
                f.setSynchroAndPrecision(synchroAndPrecision);
                ids.add(scoreService.saveScore(f, firstName, lastName).getId());
            }
            saveEvaluation(ids, idc, Firstname, Lastname);
        }}

    @Override
    public Evaluation finbyid(Long id){
        return evaluationRepository.findById(id).get();
    }
}


