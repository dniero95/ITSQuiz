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

    @OneToMany(mappedBy = "questionID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerEntity> questions = new ArrayList<>();
}
