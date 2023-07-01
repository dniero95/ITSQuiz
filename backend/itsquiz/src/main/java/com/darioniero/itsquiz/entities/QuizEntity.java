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
@Setter
public class QuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int numberOfQuestions;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private String course;

    @OneToMany
    @JoinColumn(name = "questionID")
    private List<QuestionEntity> questions = new ArrayList<>();

}
