package com.code.java.lernSituation1_backend;

public class Result {
    private Long percentCorrect;
    private Long adverageAnswerTime;
    private Long minimumAnswerTime;
    private Long maximumAnswerTime;
    private Long questionId;

    public Result(Long percentCorrect, Long adverageAnswerTime, Long minimumAnswerTime, Long maximumAnswerTime, Long questionId) {
        this.percentCorrect = percentCorrect;
        this.adverageAnswerTime = adverageAnswerTime;
        this.minimumAnswerTime = minimumAnswerTime;
        this.maximumAnswerTime = maximumAnswerTime;
        this.questionId = questionId;
    }

//region Getter & Setter

    public Long getPercentCorrect() {
        return percentCorrect;
    }

    public void setPercentCorrect(Long percentCorrect) {
        this.percentCorrect = percentCorrect;
    }

    public Long getAdverageAnswerTime() {
        return adverageAnswerTime;
    }

    public void setAdverageAnswerTime(Long adverageAnswerTime) {
        this.adverageAnswerTime = adverageAnswerTime;
    }

    public Long getMinimumAnswerTime() {
        return minimumAnswerTime;
    }

    public void setMinimumAnswerTime(Long minimumAnswerTime) {
        this.minimumAnswerTime = minimumAnswerTime;
    }

    public Long getMaximumAnswerTime() {
        return maximumAnswerTime;
    }

    public void setMaximumAnswerTime(Long maximumAnswerTime) {
        this.maximumAnswerTime = maximumAnswerTime;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    //endregion

}
