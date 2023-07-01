package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.models.Question;
import com.darioniero.itsquiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public void createQuestion(Question question) {

    }
}
