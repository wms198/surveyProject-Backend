package com.code.java.lernSituation1_backend.api.controller;

import com.code.java.lernSituation1_backend.model.Question;
import com.code.java.lernSituation1_backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /*
     * Create a new question.
     *
     * @param question the question to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new question
     */

    @PostMapping("/question")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        Question newQuestion = questionService.saveQuestion(question);
        return ResponseEntity.ok().body(newQuestion);
    }

    /*
     * Get all questions.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of products
     */
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /*
     * Get a product by ID.
     *
     * @param id the ID of the product to get
     * @return the ResponseEntity with status 200 (OK) and with body of the product, or with status 404 (Not Found) if the product does not exist
     */
    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> question = questionService.getQuestionById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*
     * Update a product by ID.
     *
     * @param id the ID of the product to update
     * @param product the updated product
     * @return the ResponseEntity with status 200 (OK) and with body of the updated product, or with status 404 (Not Found) if the product does not exist
     */
    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Question updatedQuestion = questionService.updateQuestion(id, question);
        return ResponseEntity.ok().body(updatedQuestion);
    }

    /*
     * Delete a product by ID.
     *
     * @param id the ID of the product to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Product deleted successfully"
     */
    @DeleteMapping("/question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Question deleted successfully.");
    }


}
