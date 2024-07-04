package com.code.java.lernSituation1_backend.service;

import com.code.java.lernSituation1_backend.model.Answer;
import com.code.java.lernSituation1_backend.model.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    // Save a Answer from a subject
    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    // Get all the answers
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    //  Get Answers by subjectId. subject_id
    public Optional<Answer> getAnswerBySubjectId(Long subject_id) {
        return null;
        //return answerRepository.findBySubjectID(subject_id);
    }



}
