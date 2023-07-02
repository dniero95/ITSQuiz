package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.models.Answer;
import com.darioniero.itsquiz.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    public void createAnswer(Answer answer) {

    }
}
