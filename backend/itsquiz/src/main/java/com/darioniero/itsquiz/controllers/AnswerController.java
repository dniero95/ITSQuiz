package com.darioniero.itsquiz.controllers;

import com.darioniero.itsquiz.models.Answer;
import com.darioniero.itsquiz.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping
    public void createAnswer(@RequestBody Answer answer){
        answerService.createAnswer(answer);
    }
}
