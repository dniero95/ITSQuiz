package com.darioniero.itsquiz.repositories;

import com.darioniero.itsquiz.entities.AnswerEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {
}
