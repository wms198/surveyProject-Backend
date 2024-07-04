package com.code.java.lernSituation1_backend.model.repository;


import com.code.java.lernSituation1_backend.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
AnswerRepository extends JpaRepository<Answer, Long> {
    //List<Answer> findBySubjectID(Long subject_id);
}
