package com.darioniero.itsquiz.entities;

import com.darioniero.itsquiz.models.Answer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "text",nullable = false)
    private String text;
    @Column(name = "is_true",nullable = false)
    private boolean isTrue;
    @Column(name = "point",nullable = false)
    private int point;
    @Column(name = "question_id",nullable = false)
    private Long questionID;
}


