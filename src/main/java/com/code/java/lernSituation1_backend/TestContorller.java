package com.code.java.lernSituation1_backend;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
