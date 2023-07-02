package com.darioniero.itsquiz.controllers;

import com.darioniero.itsquiz.models.Quiz;
import com.darioniero.itsquiz.models.QuizWithID;
import com.darioniero.itsquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/quiz")
@RestController
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public void createQuiz(@RequestBody Quiz quiz){
        quizService.createQuiz(quiz);
    }

    @GetMapping
    public List<QuizWithID> fetchAllQuiz(){
        return quizService.fetchAllQuiz();
    }

    @PutMapping
    public void updateQuiz(Long id, @RequestBody Quiz quiz){
        quizService.updateQuiz(id, quiz);
    }

    @DeleteMapping
    public void deleteQuizById(Long id){
        quizService.deleteQuizById(id);
    }

}
