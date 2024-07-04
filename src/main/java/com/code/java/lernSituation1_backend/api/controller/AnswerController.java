package com.code.java.lernSituation1_backend.api.controller;


import com.code.java.lernSituation1_backend.Result;
import com.code.java.lernSituation1_backend.model.Answer;
import com.code.java.lernSituation1_backend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @GetMapping("/answers/{subject_id}")
    public ResponseEntity<Answer> getAnswerBySubjectId(@PathVariable Long subject_id) {
        Optional<Answer> answer = answerService.getAnswerBySubjectId(subject_id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get results
    @GetMapping("/results")
    public List<Answer> getResults() {
        List<Answer> allAnswers =  answerService.getAllAnswers();
        Long duration = 0L;
        int times =1;
        boolean percentCorrect;
        Long adverageAnswerTime;
        Long minimumAnswerTime = 0L;
        Long maximumAnswerTime = 0L;
        Long questionId;
        ArrayList<Result> results = new ArrayList<>();

        for (Answer answer : allAnswers) {
            if(times == 1){
                duration = answer.getDuration();
                duration = minimumAnswerTime;
                minimumAnswerTime =maximumAnswerTime;
            }else if(times > 1){
                duration = answer.getDuration();
                if(duration > maximumAnswerTime)
                    maximumAnswerTime = duration;
                else if(duration  < minimumAnswerTime)
                    minimumAnswerTime = duration;
            }
            times ++;
            percentCorrect = answer.getOption().getIsCorrect();
            questionId = answer.getOption().getQuestion().getId();
        }
        return null;
    }

}
