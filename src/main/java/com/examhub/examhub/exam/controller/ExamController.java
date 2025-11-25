package com.examhub.examhub.exam.controller;

import com.examhub.examhub.common.dto.ResponseTO;
import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.exam.dto.AssessmentTO;
import com.examhub.examhub.exam.model.AssessmentBO;
import com.examhub.examhub.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {
    ResponseTO response;
    @Autowired
    private ExamService examService;

    @PostMapping("/create")
    public ResponseEntity<?> createAssessment(@RequestBody AssessmentTO assessment){
        response = ResponseTO.responseBuilder(200, "C0001","created successfully", "/exam/create","assessment", examService.createAssessment(assessment));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateAssessment(@RequestBody AssessmentTO assessment){
        response = ResponseTO.responseBuilder(200, "C0002","updated successfully", "/exam/update","assessment", examService.updateAssessment(assessment));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAssessment(@PathVariable Integer id){
        response = ResponseTO.responseBuilder(200, "C0003","deleted successfully", "/exam/delete","assessment", examService.deleteAssessment(id));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> fetchAssessment(@PathVariable Integer id){
        response = ResponseTO.responseBuilder(200, "C0005","fetched successfully", "/exam/get","assessment", examService.fetchAssessment(id));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<?> searchAssessment(@RequestBody SearchRequestTO searchRequest){
        response = ResponseTO.responseBuilder(200, "C0005","fetched successfully", "/exam/search","assessment", examService.searchAssessment(searchRequest));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<?> importAssessment(@RequestBody SearchRequestTO searchRequest){
        response = ResponseTO.responseBuilder(200, "C0005","fetched successfully", "/exam/search","assessment", examService.searchAssessment(searchRequest));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
}
