package com.darioniero.itsquiz.entities;

import com.darioniero.itsquiz.models.Answer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text",nullable = false)
    private String text;
    @Column(name="quiz_id",nullable = false)
    private Long quizID;

    @OneToMany
    @JoinColumn(name = "question_id")
    private List<AnswerEntity> answers = new ArrayList<>();
}


