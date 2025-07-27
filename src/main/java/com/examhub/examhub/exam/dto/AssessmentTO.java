package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AssessmentTO {

    private Integer id;
    private Integer recruiterId;
    private String assessmentType;
    private String status;
    private String title;
    private String description;
    private String instructions;

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
