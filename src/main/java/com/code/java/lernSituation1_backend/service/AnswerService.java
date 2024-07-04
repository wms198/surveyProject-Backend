package com.code.java.lernSituation1_backend.service;

import com.code.java.lernSituation1_backend.model.Answer;
import com.code.java.lernSituation1_backend.model.Subject;
import com.code.java.lernSituation1_backend.model.repository.AnswerRepository;
import com.code.java.lernSituation1_backend.model.repository.OptionRepository;
import com.code.java.lernSituation1_backend.model.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final OptionRepository optionRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, OptionRepository optionRepository, SubjectRepository subjectRepository) {
        this.answerRepository = answerRepository;
        this.optionRepository = optionRepository;
        this.subjectRepository = subjectRepository;
    }
    public Optional<Subject> getSubjectByIdnetifier(String idnetifier){
        return subjectRepository.findByIdentifier(idnetifier);
    }
    public Answer saveAnswer(String subject_identifier, int option_id, int duration) {
        Answer answer = new Answer();
        answer.setDuration(duration);
        answer.setOption(optionRepository.findById((long)option_id).get());

        Optional<Subject> subject = subjectRepository.findByIdentifier(subject_identifier);
        if(!subject.isPresent()){
            Subject newSubject = new Subject();
            newSubject.setIdentifier(subject_identifier);
            subjectRepository.save(newSubject);
            answer.setSubject(newSubject);
        }else{
            answer.setSubject(subject.get());
        }

        return saveAnswer(answer);
    }

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
