package com.darioniero.itsquiz.models;

import com.darioniero.itsquiz.entities.AnswerEntity;
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
public class QuestionWithIdD extends Question{
    private Long id;
    private List<AnswerEntity> answers = new ArrayList<>();
}
