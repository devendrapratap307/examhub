package com.examhub.examhub.user.controller;

import com.examhub.examhub.common.dto.ResponseTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    ResponseTO response;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> fetchAssessment(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<?> searchUser(){
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
}
