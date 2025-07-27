package com.examhub.examhub.exam.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuestionTopicTO {

    private Integer id;
//    private Assessment assessment;
    private String topicName;
    private String description;
    private double weightage;

}