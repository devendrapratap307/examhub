package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class CandidateAssessmentTO {

    private Integer id;
//    private Assessment assessment;
    private Integer candidateId;
    private String name;
    private String email;
    private String phone;
    private String status;
    private double score;
    private String feedback;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer duration;
    private double maxScore;
    private double passingScore;

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

}