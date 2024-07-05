package com.code.java.lernSituation1_backend.api.controller;


import com.code.java.lernSituation1_backend.Result;
import com.code.java.lernSituation1_backend.model.Answer;
import com.code.java.lernSituation1_backend.model.Option;
import com.code.java.lernSituation1_backend.model.Question;
import com.code.java.lernSituation1_backend.model.Subject;
import com.code.java.lernSituation1_backend.request.AnswerRequest;
import com.code.java.lernSituation1_backend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
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
    @GetMapping("/user/{subject_id}")
    public ResponseEntity<Subject> getAnswerBySubjectId(@PathVariable String subject_id) {
        Optional<Subject> sub = answerService.getSubjectByIdnetifier(subject_id);
        return sub.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Create an answer from subject
    @PostMapping("/answer")
    public ResponseEntity<Answer> saveAnswer(@RequestBody AnswerRequest answer) {
        Answer newAnswer = answerService.saveAnswer(answer.getSubject_identifier(), answer.getOption_id(), answer.getDuration());
        return ResponseEntity.ok().body(newAnswer);
    }

    //Get a answer by subject_id
    @GetMapping("/answers/{subject_id}")
    public ResponseEntity<Answer> getSubjectByIdentifier(@PathVariable Long subject_id) {
        Optional<Answer> answer = answerService.getAnswerBySubjectId(subject_id);
        return answer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Get results
    @GetMapping("/results")
    public ResponseEntity<Collection<Result>> getResults() {
        List<Answer> allAnswers =  answerService.getAllAnswers();
        Map<Question, Result> allResults = new HashMap<>();
        for (Answer answer : allAnswers) {
            Option option = answer.getOption();
            Question question = option.getQuestion();
            Result r;
            if(allResults.containsKey(question))
                r = allResults.get(question);
            else{
                r = new Result(question);
                allResults.put(question, r);
            }
            r.addAnswer(answer, option.getIsCorrect());
        }
        return ResponseEntity.ok().body(allResults.values());
    }

}
