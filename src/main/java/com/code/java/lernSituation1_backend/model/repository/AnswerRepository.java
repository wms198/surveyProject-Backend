package com.code.java.lernSituation1_backend.model.repository;


import com.code.java.lernSituation1_backend.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface
AnswerRepository extends JpaRepository<Answer, Long> {
    public List<Answer> findAllByOrderByOptionIdDesc();
}
