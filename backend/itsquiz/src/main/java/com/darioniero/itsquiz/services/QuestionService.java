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

    /**
     * Create a new question in the database
     * @param question The question that will be created
     */
    public void createQuestion(Question question) {
        questionRepository.save(fromQuestionToQuestionEntity(question));
    }

    /**
     * Return all questions in the database
     * @return
     */
    public List<QuestionWithIdD> fetchAllQuestions() {
        List<QuestionWithIdD> questions = new ArrayList<>();

        for (QuestionEntity questionEntity : questionRepository.findAll()) {
            questions.add(fromQuestionEntityToQuestionWithID(questionEntity));
        }
        return questions;
    }

    /**
     * Update a question on the database
     * @param id the id of the question that will be updated
     * @param question The new fields of the question that will be updated
     */
    public void updateQuestion(Long id, Question question) {
        Optional<QuestionEntity> questionToUpdate = questionRepository.findById(id);
        if (questionToUpdate.isPresent()) {
            questionToUpdate.get().setText(question.getText());
            questionToUpdate.get().setQuizID(question.getQuizID());
            questionRepository.save(questionToUpdate.get());
        }
    }

    /**
     * delete a question in the database
     * @param id the id of the question that will be deleted
     */
    public void deleteQuestionByID(long id) {
        questionRepository.deleteById(id);
    }

    /**
     * convert a Question model to a question entity
     * @param question
     * @return the question Entity
     */
    private QuestionEntity fromQuestionToQuestionEntity(Question question) {
        return QuestionEntity.builder()
                .text(question.getText())
                .quizID(question.getQuizID())
                .build();
    }

    /**
     * convert a question entity to a QuestionWithID model
     * @param questionEntity
     * @return
     */
    private QuestionWithIdD fromQuestionEntityToQuestionWithID(QuestionEntity questionEntity) {
        return QuestionWithIdD.builder()
                .id(questionEntity.getId())
                .text(questionEntity.getText())
                .quizID(questionEntity.getQuizID())
                .answers(questionEntity.getAnswers())
                .build();
    }


}
