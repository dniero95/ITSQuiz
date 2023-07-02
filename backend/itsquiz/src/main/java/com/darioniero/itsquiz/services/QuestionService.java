package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.entities.QuestionEntity;
import com.darioniero.itsquiz.entities.QuizEntity;
import com.darioniero.itsquiz.models.Question;
import com.darioniero.itsquiz.models.QuestionWithIdD;
import com.darioniero.itsquiz.models.Quiz;
import com.darioniero.itsquiz.models.QuizWithID;
import com.darioniero.itsquiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public void createQuestion(Question question) {
        questionRepository.save(fromQuestionToQuestionEntity(question));
    }

    public void updateQuestion(Long id, Question question) {
    }

    public void deleteQuestionByID(long id) {
    }

    private QuestionEntity fromQuestionToQuestionEntity(Question question) {
        return QuestionEntity.builder()
                .text(question.getText())
                .quizID(question.getQuizID())
                .build();
    }

    private QuestionWithIdD fromQuestionEntityToQuestionWithID(QuestionEntity questionEntity) {
        return QuestionWithIdD.builder()
                .id(questionEntity.getId())
                .text(questionEntity.getText())
                .quizID(questionEntity.getQuizID())
                .build();
    }


    public List<QuestionEntity> fetchAllQuestions() {
        return (List<QuestionEntity>) questionRepository.findAll();
    }
}
