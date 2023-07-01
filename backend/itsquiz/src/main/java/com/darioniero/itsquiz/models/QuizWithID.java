package com.darioniero.itsquiz.models;

import com.darioniero.itsquiz.entities.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class QuizWithID extends Quiz{
    private Long id;
    private List<QuestionEntity> questions = new ArrayList<>();
}
