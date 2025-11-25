package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class CandidateAssessmentTO {

    private Integer id;
    private Integer candidateId;
    private Integer recruiterId;
    private Integer assessmentId;
    private String status;
    private LocalDateTime expirationDate;

    // After completion of assessment
    private String feedback; // by recruiter
    private LocalDateTime startTime; // started by candidate
    private LocalDateTime endTime;  // ended by candidate
    private Integer duration; // total time

    private double marks; // scored by candidate
    private double maxScore;
    private double passingScore;

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}