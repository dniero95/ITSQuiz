package com.darioniero.itsquiz.controllers;

import com.darioniero.itsquiz.models.Quiz;
import com.darioniero.itsquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/quiz")
@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    public void createQuiz(@RequestBody Quiz quiz){
        quizService.createQuiz(quiz);
    }

    @GetMapping
    public List<Quiz> fetchAllQuiz(){
        return quizService.fetchAllQuiz();
    }
}
