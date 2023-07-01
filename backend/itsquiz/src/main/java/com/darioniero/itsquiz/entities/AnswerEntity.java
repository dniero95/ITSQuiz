package com.darioniero.itsquiz.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private boolean isTrue;
    @Column(nullable = false)
    private int point;
    @Column(nullable = false)
    private Long questionID;
}
