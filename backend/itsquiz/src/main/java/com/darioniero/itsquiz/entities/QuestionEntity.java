package com.darioniero.itsquiz.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private Long quizID;

    @OneToMany
    @JoinColumn(name = "answerID")
    private List<AnswerEntity> answers = new ArrayList<>();
}
