package com.darioniero.itsquiz.controllers;

import com.darioniero.itsquiz.models.Answer;
import com.darioniero.itsquiz.models.AnswerWithID;
import com.darioniero.itsquiz.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    public void createAnswer(@RequestBody Answer answer){
        answerService.createAnswer(answer);
    }

    @GetMapping
    public List<AnswerWithID> fetchAllAnswers(){
        return answerService.fetchAllAnswers();
    }

    @PutMapping
    public void updateAnswer(Long id, @RequestBody Answer answer){
        answerService.updateAnswer(id, answer);
    }
}
