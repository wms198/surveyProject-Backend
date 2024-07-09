package com.code.java.lernSituation1_backend.api.controller;

import com.code.java.lernSituation1_backend.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class PasswordController {


    @Autowired
        public PasswordService passwordService;

        @GetMapping("/password")
        public ResponseEntity getPassword() {
            return new ResponseEntity(passwordService.getTeacherPassword(), HttpStatus.OK);
        }
    }

