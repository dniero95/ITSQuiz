package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.entities.AnswerEntity;
import com.darioniero.itsquiz.models.Answer;
import com.darioniero.itsquiz.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    public void createAnswer(Answer answer) {
        AnswerEntity toSave = fromAnswerToAnswerEntity(answer);
        answerRepository.save(toSave);
    }

    private AnswerEntity fromAnswerToAnswerEntity(Answer answer){
        return AnswerEntity.builder()
                .text(answer.getText())
                .point(answer.getPoint())
                .isTrue(answer.isTrue())
                .questionID(answer.getQuestionID() )
                .build();
    }
}
