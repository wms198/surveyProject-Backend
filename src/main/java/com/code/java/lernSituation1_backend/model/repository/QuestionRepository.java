package com.code.java.lernSituation1_backend.model.repository;

import com.code.java.lernSituation1_backend.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long>  {
}


//package com.code.java.lernSituation1_backend.model.repository;
//import com.code.java.lernSituation1_backend.model.Question;