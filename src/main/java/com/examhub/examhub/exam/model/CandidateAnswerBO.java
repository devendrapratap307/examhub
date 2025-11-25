package com.examhub.examhub.exam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "candidate_answer")
public class CandidateAnswerBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "score", precision = 22, scale = 6, nullable = false)
    private double score;
    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "candidate_id")
    private Integer candidateId;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "answer_option", columnDefinition = "TEXT")
    private String answerOption; // A, B, C, D, E

    @Column(name = "answer", columnDefinition = "TEXT")
    private String answer;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
