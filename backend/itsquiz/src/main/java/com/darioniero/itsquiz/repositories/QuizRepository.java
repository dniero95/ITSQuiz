package com.darioniero.itsquiz.repositories;

import com.darioniero.itsquiz.entities.QuizEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository< Long, QuizEntity> {
}
