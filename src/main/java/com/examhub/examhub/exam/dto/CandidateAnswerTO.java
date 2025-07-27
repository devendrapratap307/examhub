package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CandidateAnswerTO {

    private Integer id;
    private String answer;
    private double score;
    private Boolean isCorrect;

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

//    private Assessment assessment;
//    private Question question;

    private Integer candidateId;

}
