package com.darioniero.itsquiz.controllers;

import com.darioniero.itsquiz.models.Question;
import com.darioniero.itsquiz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @PostMapping
    public void createQuestion(Question question){
        questionService.createQuestion(question);
    }
}
