package com.examhub.examhub.user.controller;

import com.examhub.examhub.common.dto.ResponseTO;
import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.user.dto.UserTO;
import com.examhub.examhub.user.model.UserBO;
import com.examhub.examhub.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
            private UserService userService;
    ResponseTO response;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserTO user){
        response = ResponseTO.responseBuilder(200, "C0002","created successfully", "/user/create","user", userService.createUser(user));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserTO user){
        response = ResponseTO.responseBuilder(200, "C0002","updated successfully", "/user/update","user", userService.updateUser(user));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        response = ResponseTO.responseBuilder(200, "C0003","deleted successfully", "/user/delete","user", userService.deleteUser(id));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> fetchUser(@PathVariable Integer id){
        response = ResponseTO.responseBuilder(200, "C0005","fetched successfully", "/user/get","user", userService.findUserById(id));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchUser(@RequestBody SearchRequestTO searchRequest){
        response = ResponseTO.responseBuilder(200, "C0005","fetched successfully", "/user/search","user", userService.searchUser(searchRequest));
        return new ResponseEntity<ResponseTO>(response, HttpStatus.OK);
    }
}
