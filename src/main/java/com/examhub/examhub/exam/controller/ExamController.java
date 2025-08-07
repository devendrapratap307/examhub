package com.examhub.examhub.exam.controller;

import com.examhub.examhub.common.dto.ResponseTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")
public class ExamController {
    ResponseTO response;

    @PostMapping("/create")
    public ResponseEntity<?> createAssessment(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateAssessment(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAssessment(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> fetchAssessment(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<?> searchAssessment(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
}
