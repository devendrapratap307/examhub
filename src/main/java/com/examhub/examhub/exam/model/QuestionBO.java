package com.examhub.examhub.exam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "question")
public class QuestionBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "assessment_id", nullable = false)
//    private Assessment assessment;

    @Column(name = "question_text", columnDefinition = "TEXT", nullable = false)
    private String question;

    @Column(name = "question_type", length = 50, nullable = false)
    private String questionType;

    @Column(name = "a_opt", columnDefinition = "TEXT")
    private String aOpt;

    @Column(name = "b_opt", columnDefinition = "TEXT")
    private String bOpt;

    @Column(name = "c_opt", columnDefinition = "TEXT")
    private String cOpt;

    @Column(name = "d_opt", columnDefinition = "TEXT")
    private String dOpt;

    @Column(name = "e_opt", columnDefinition = "TEXT")
    private String eOpt;

    @Column(name = "answer", columnDefinition = "TEXT")
    private String answer;

    @Column(name = "score", precision = 22, scale = 6, nullable = false)
    private double score;

    @Column(name = "negative_score")
    private Integer negativeScore;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
