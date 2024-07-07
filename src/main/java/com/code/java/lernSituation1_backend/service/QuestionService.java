package com.code.java.lernSituation1_backend.service;

import com.code.java.lernSituation1_backend.model.Option;
import com.code.java.lernSituation1_backend.model.Question;
import com.code.java.lernSituation1_backend.model.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /*
     * Save a product.
     *
     * @param product the entity to save
     * @return the persisted entity
     */
    public Question saveQuestion(Question question) {
        return (Question) questionRepository.save(question);
    }

    /*
     * Get all the products.
     *
     * @return the list of entities
     */
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    /*
     * Get one product by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    /*
     * Update a product.
     *
     * @param id the ID of the entity
     * @param updatedProduct the updated entity
     * @return the updated entity
     */
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Optional<Question> existingQuestion = questionRepository.findById(id);
        if(existingQuestion.isPresent()) {
            Question question = existingQuestion.get();
            question.setQuestionContent(updatedQuestion.getQuestionContent());

            for (Option existingOption : question.getOptions()) {
                for (Option updatedOption : updatedQuestion.getOptions()) {
                    if (existingOption.getId().equals(updatedOption.getId())) {
                        existingOption.setValue(updatedOption.getValue());
                        existingOption.setCorrect(updatedOption.getIsCorrect());
                    }
                }
            }
            return questionRepository.save(question);
        }else{
            throw new RuntimeException("Question not found");
        }

    }

    /*
     * Delete the product by ID.
     *
     * @param id the ID of the entity
     */
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }


}
