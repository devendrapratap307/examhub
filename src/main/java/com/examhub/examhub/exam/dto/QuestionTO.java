package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class QuestionTO {

    private Integer id;
    private Integer questionTopicId;
//    private Assessment assessment;
    private String question;
    private String questionType;
    private String aOpt;
    private String bOpt;
    private String cOpt;
    private String dOpt;
    private String eOpt;
    private String answer;
    private double marks;
    private double negativeMarks;

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
