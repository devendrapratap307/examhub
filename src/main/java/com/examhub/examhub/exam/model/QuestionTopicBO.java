package com.examhub.examhub.exam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question_topic")
public class QuestionTopicBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "assessment_id", nullable = false)
//    private Assessment assessment;

    @Column(name = "topic_name", length = 255, nullable = false)
    private String topicName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "weightage", precision = 22, scale = 6, nullable = false)
    private double weightage;

}
