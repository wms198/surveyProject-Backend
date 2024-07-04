package com.code.java.lernSituation1_backend.model.repository;

import com.code.java.lernSituation1_backend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long>  {
    Optional<Subject> findByIdentifier(String identifier);
}


//package com.code.java.lernSituation1_backend.model.repository;
//import com.code.java.lernSituation1_backend.model.Question;