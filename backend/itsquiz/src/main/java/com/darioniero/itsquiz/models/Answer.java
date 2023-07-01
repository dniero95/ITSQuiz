package com.darioniero.itsquiz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Answer {
    private String text;
    private boolean isTrue;
    private int point;
    private Long questionID;

}
