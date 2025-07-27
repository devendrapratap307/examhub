package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class QuestionTO {

    private Integer id;
//    private Assessment assessment;
    private String questionText;
    private String questionType;
    private String aOpt;
    private String bOpt;
    private String cOpt;
    private String dOpt;
    private String eOpt;
    private String answer;
    private double score;
    private Integer negativeScore;

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
