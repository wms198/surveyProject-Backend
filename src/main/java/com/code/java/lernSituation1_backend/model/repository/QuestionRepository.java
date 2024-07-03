package com.code.java.lernSituation1_backend.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository<Question> extends JpaRepository<Question, Long>  {
}


//package com.code.java.lernSituation1_backend.model.repository;
//import com.code.java.lernSituation1_backend.model.Question;