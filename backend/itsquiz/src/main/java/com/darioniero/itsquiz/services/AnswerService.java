package com.darioniero.itsquiz.services;

import com.darioniero.itsquiz.entities.AnswerEntity;
import com.darioniero.itsquiz.models.Answer;
import com.darioniero.itsquiz.models.AnswerWithID;
import com.darioniero.itsquiz.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    final
    AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    /**
     * save an answer on the database
     * @param answer
     */
    public void createAnswer(Answer answer) {
        AnswerEntity toSave = fromAnswerToAnswerEntity(answer);
        answerRepository.save(toSave);
    }

    /**
     * return all answer
     * @return
     */
    public List<AnswerWithID> fetchAllAnswers() {

        List<AnswerWithID> answers = new ArrayList<>();

        for (AnswerEntity answerEntity : answerRepository.findAll()) {
            answers.add(fromAnswerEntityToAnswerWithID(answerEntity));
        }

        return answers;
    }

    /**
     * convert an Answer model to an Answer entity
     * @param answer
     * @return
     */
    private AnswerEntity fromAnswerToAnswerEntity(Answer answer) {
        return AnswerEntity.builder()
                .text(answer.getText())
                .point(answer.getPoint())
                .isTrue(answer.isTrue())
                .questionID(answer.getQuestionID())
                .build();
    }

    /**
     * convert a answer entity to an answer with id model
     * @param answerEntity
     * @return
     */
    private AnswerWithID fromAnswerEntityToAnswerWithID(AnswerEntity answerEntity) {
        return AnswerWithID.builder()
                .id(answerEntity.getId())
                .point(answerEntity.getPoint())
                .text(answerEntity.getText())
                .isTrue(answerEntity.isTrue())
                .questionID(answerEntity.getQuestionID())
                .build();
    }

    public void updateAnswer(Long id, Answer answer) {
        Optional<AnswerEntity> answerToUpdate = answerRepository.findById(id);
        if (answerToUpdate.isPresent()){
            answerToUpdate.get().setPoint(answer.getPoint());
            answerToUpdate.get().setTrue (answer.isTrue());
            answerToUpdate.get().setText(answer.getText());
            answerToUpdate.get().setQuestionID (answer.getQuestionID());

            answerRepository.save(answerToUpdate.get());
        }
    }

    public void deleteAnswerByID(Long id) {
        answerRepository.deleteById(id);
    }
}
