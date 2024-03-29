package com.darioniero.itsquiz.controllers;

import com.darioniero.itsquiz.entities.QuestionEntity;
import com.darioniero.itsquiz.models.Question;
import com.darioniero.itsquiz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @PostMapping
    public void createQuestion(@RequestBody Question question){
        questionService.createQuestion(question);
    }

    @GetMapping
    public List<QuestionEntity> fetchAllQuestions(){
        return questionService.fetchAllQuestions();
    }

    @PutMapping
    public void updateQuetion(Long id, @RequestBody Question question){
     questionService.updateQuestion(id, question);
    }

    @DeleteMapping
    public void deleteQuestionByID(long id){
        questionService.deleteQuestionByID(id);
    }
}
