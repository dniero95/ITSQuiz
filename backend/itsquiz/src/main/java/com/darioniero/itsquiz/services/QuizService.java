package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.entities.QuizEntity;
import com.darioniero.itsquiz.models.Quiz;
import com.darioniero.itsquiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;


    private QuizEntity fromQuizToQuizEntity(Quiz quiz) {
        return QuizEntity.builder()
                .id(quiz.getId())
                .name(quiz.getName())
                .description(quiz.getDescription())
                .numberOfQuestions(quiz.getNumberOfQuestions())
                .duration(quiz.getDuration())
                .course(quiz.getCourse())
                .build();
    }

    private Quiz fromQuizEntityToQuiz(QuizEntity quizEntity) {
        return Quiz.builder()
                .id(quizEntity.getId())
                .name(quizEntity.getName())
                .description(quizEntity.getDescription())
                .numberOfQuestions(quizEntity.getNumberOfQuestions())
                .duration(quizEntity.getDuration())
                .course(quizEntity.getCourse())
                .build();
    }


    public void createQuiz(Quiz quiz) {
        quizRepository.save(fromQuizToQuizEntity(quiz));
    }
    public List<Quiz> fetchAllQuiz() {

        List<Quiz> quizzes = new ArrayList<>();

        for (QuizEntity quizEntity :
                quizRepository.findAll()) {
            quizzes.add(fromQuizEntityToQuiz(quizEntity));
        }

        return quizzes;
    }


}
