package com.darioniero.itsquiz.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Quiz {

    private String name;

    private String description;

    private int numberOfQuestions;

    private int duration;

    private String course;

}
