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

    @Column(name = "answer", columnDefinition = "TEXT")
    private String answer;

    @Column(name = "score", precision = 22, scale = 6, nullable = false)
    private double score;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "assessment_id", nullable = false)
//    private Assessment assessment;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "question_id", nullable = false)
//    private Question question;

    @Column(name = "candidate_id", nullable = false)
    private Integer candidateId;

}
