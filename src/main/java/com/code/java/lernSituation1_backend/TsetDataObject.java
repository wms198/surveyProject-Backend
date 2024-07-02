package com.code.java.lernSituation1_backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TsetDataObject {
    @Id
    private long id;
    @Column
    private String username;


}
