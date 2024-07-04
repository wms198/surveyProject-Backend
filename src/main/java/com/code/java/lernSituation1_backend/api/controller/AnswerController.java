package com.code.java.lernSituation1_backend.api.controller;


import com.code.java.lernSituation1_backend.model.Answer;
import com.code.java.lernSituation1_backend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

     // Get all answers of subjects
    @GetMapping("/answers")
    public List<Answer> getAnswers() {
        return answerService.getAllAnswers();
    }

    //Get a answer by subject_id
    @GetMapping("/answers/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long subject_id) {
        Optional<Answer> answer = answerService.getAnswerById(subject_id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
