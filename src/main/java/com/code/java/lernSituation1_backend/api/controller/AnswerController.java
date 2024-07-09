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
        Map<Long, Result> allResultsTree = new TreeMap<>();
        for (Answer answer : allAnswers) {
            Option option = answer.getOption();
            Question question = option.getQuestion();
            Long qId = question.getId();
            Result r;
            if(allResultsTree.containsKey(qId))
                r = allResultsTree.get(qId);
            else{
                r = new Result(question);
                allResultsTree.put(qId, r);
            }
            r.addAnswer(answer, option.getIsCorrect());
        }
        return ResponseEntity.ok().body(allResultsTree.values());
    }

    //Insert option in OptionTable
    @PostMapping("/options")
    public ResponseEntity<Option> saveOption(@RequestBody Option option) {
        Option newOption = answerService.saveOption(option);
        return ResponseEntity.ok().body(newOption);
    }

    //Delete option in optionTable
    @DeleteMapping("/options/{id}")
    public ResponseEntity<String> deleteOption(@PathVariable Long id) {
        answerService.deleteOption(id);
        return ResponseEntity.ok("Option deleted successfully.");
    }



}
