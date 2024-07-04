package com.code.java.lernSituation1_backend;

import com.code.java.lernSituation1_backend.model.Answer;
import com.code.java.lernSituation1_backend.model.Question;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    private int total = 0;
    private int totalTime = 0;
    private int correct = 0;
    private int adverageAnswerTime = 0;
    private int minimumAnswerTime = 9999999;
    private int maximumAnswerTime = 0;
    private Question question;

    public Result(Question question){
        this.question = question;
    }

    public void addAnswer(Answer a, boolean isCorrect){
        total++;
        if(isCorrect)
            correct++;
        int duration = a.getDuration();
        minimumAnswerTime = Math.min(duration, minimumAnswerTime);
        maximumAnswerTime = Math.max(duration, maximumAnswerTime);
        totalTime += duration;
        adverageAnswerTime = totalTime / total;
    }
    public double getPercentage(){
        return ((double)correct / (double)total) * 100.0;
    }

    @JsonProperty("average")
    public int getAdverageAnswerTime() {
        return adverageAnswerTime;
    }

    @JsonProperty("minimum")
    public int getMinimumAnswerTime() {
        return minimumAnswerTime;
    }

    @JsonProperty("maximum")
    public int getMaximumAnswerTime() {
        return maximumAnswerTime;
    }

    public Question getQuestion() {
        return question;
    }

}
