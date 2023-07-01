package com.darioniero.itsquiz.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quiz {

    private Long id;

    private String name;

    private String description;

    private int numberOfQuestions;

    private int duration;

    private String course;

}
