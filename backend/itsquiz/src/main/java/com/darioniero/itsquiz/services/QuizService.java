package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.entities.QuizEntity;
import com.darioniero.itsquiz.models.Quiz;
import com.darioniero.itsquiz.models.QuizWithID;
import com.darioniero.itsquiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;




    public void createQuiz(Quiz quiz) {
        quizRepository.save(fromQuizToQuizEntity(quiz));
    }

    public List<QuizWithID> fetchAllQuiz() {

        List<QuizWithID> quizzes = new ArrayList<>();

        for (QuizEntity quizEntity :
                quizRepository.findAll()) {
            quizzes.add(fromQuizEntityToQuizWithID(quizEntity));
        }

        return quizzes;
    }


    public void updateQuiz(Long id, Quiz quiz) {
        Optional<QuizEntity> quizToUpdate = quizRepository.findById(id);

        if (quizToUpdate.isPresent()) {
            quizToUpdate.get().setName(quiz.getName());
            quizToUpdate.get().setDescription(quiz.getDescription());
            quizToUpdate.get().setNumberOfQuestions(quiz.getNumberOfQuestions());
            quizToUpdate.get().setDuration(quiz.getDuration());
            quizToUpdate.get().setCourse(quiz.getCourse());

            quizRepository.save(quizToUpdate.get());
        }
    }

    public void deleteQuizById(Long id) {
        Optional<QuizEntity> quizToDelete = (quizRepository.findById(id));
        quizToDelete.ifPresent(quizEntity -> quizRepository.delete(quizEntity));

    }

    private QuizEntity fromQuizToQuizEntity(Quiz quiz) {
        return QuizEntity.builder()
                .name(quiz.getName())
                .description(quiz.getDescription())
                .numberOfQuestions(quiz.getNumberOfQuestions())
                .duration(quiz.getDuration())
                .course(quiz.getCourse())
                .build();
    }

    private QuizWithID fromQuizEntityToQuizWithID(QuizEntity quizEntity) {
        return QuizWithID.builder()
                .id(quizEntity.getId())
                .name(quizEntity.getName())
                .description(quizEntity.getDescription())
                .numberOfQuestions(quizEntity.getNumberOfQuestions())
                .duration(quizEntity.getDuration())
                .course(quizEntity.getCourse())
                .questions(quizEntity.getQuestions())
                .build();
    }

}
