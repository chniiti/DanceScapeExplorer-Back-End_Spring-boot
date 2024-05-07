package com.dance_scacpe_explorer.rythmcoders.Controller;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
import com.dance_scacpe_explorer.rythmcoders.Entities.Evaluation;
import com.dance_scacpe_explorer.rythmcoders.Services.EvaluationService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/add/{idc}/{Firstname}/{Lastname}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Evaluation addEvaluation(@RequestBody List<Long> idscores,@PathVariable("idc")Long idc,@PathVariable("Firstname")String Firstname,@PathVariable("Lastname")String Lastname) {
        return evaluationService.saveEvaluation(idscores,idc,Firstname,Lastname);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteEvaluation(@PathVariable("id") Long id) {
        evaluationService.deleteEvaluation(id);
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Evaluation> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }

    @GetMapping("/allcompetions")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Competition> getAllCompetition() {
        return evaluationService.allcompetion();
    }

    @GetMapping("/eva/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Evaluation byid(@PathVariable("id") Long id) {
        return evaluationService.finbyid(id);
    }

    @PostMapping("/downloadExcel")
    @CrossOrigin(origins = "http://localhost:4200")
    public void downloadExcel(@RequestBody Competition c,HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=Competition.xls";

        response.setHeader(headerKey, headerValue);

        evaluationService.generateExcel(c,response);

        response.flushBuffer();
    }




    @PutMapping("/importExcel/{idc}/{Firstname}/{Lastname}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void importExcel(@PathVariable("idc") Long idc,
                            @PathVariable("Firstname") String Firstname,
                            @PathVariable("Lastname") String Lastname,
                            @RequestParam("file") MultipartFile file) throws IOException {
        evaluationService.importExcel(file, idc, Firstname, Lastname);
    }

}
