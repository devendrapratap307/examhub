package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CandidateAnswerTO {

    private Integer id;

    private double score;
    private Boolean isCorrect;

    private Integer candidateId;
    private Integer questionId;
    private String answerOption; // A, B, C, D, E
    private String answer; // Input Based

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

}
