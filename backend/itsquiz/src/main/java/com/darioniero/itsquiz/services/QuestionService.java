package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.entities.QuestionEntity;
import com.darioniero.itsquiz.models.Question;
import com.darioniero.itsquiz.models.QuestionWithIdD;
import com.darioniero.itsquiz.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    final
    QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(Question question) {
        questionRepository.save(fromQuestionToQuestionEntity(question));
    }

    public List<QuestionWithIdD> fetchAllQuestions() {
        List<QuestionWithIdD> questions = new ArrayList<>();

        for (QuestionEntity questionEntity : questionRepository.findAll()) {
            questions.add(fromQuestionEntityToQuestionWithID(questionEntity));
        }
        return questions;
    }

    public void updateQuestion(Long id, Question question) {
        Optional<QuestionEntity> questionToUpdate = questionRepository.findById(id);
        if (questionToUpdate.isPresent()) {
            questionToUpdate.get().setText(question.getText());
            questionToUpdate.get().setQuizID(question.getQuizID());
            questionRepository.save(questionToUpdate.get());
        }
    }

    public void deleteQuestionByID(long id) {
        questionRepository.deleteById(id);
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
                .answers(questionEntity.getAnswers())
                .build();
    }


}
