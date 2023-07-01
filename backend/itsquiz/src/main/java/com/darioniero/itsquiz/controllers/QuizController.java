package com.darioniero.itsquiz.controllers;

import com.darioniero.itsquiz.models.Quiz;
import com.darioniero.itsquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/quiz")
@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> fetchAllQuiz(){
        return quizService.fetchAllQuiz();
    }
}
