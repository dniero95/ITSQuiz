package com.darioniero.itsquiz.repositories;

import com.darioniero.itsquiz.entities.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {
}
