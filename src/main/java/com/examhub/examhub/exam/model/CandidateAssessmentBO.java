package com.examhub.examhub.exam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "candidate_assessment")
public class CandidateAssessmentBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;



    @Column(name = "candidate_id", nullable = false)
    private Integer candidateId;
    @Column(name = "recruiter_id", nullable = false)
    private Integer recruiterId;
    @Column(name = "assessment_idd", nullable = false)
    private Integer assessmentId;
    @Column(name = "status", length = 20)
    private String status;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;


    // After completion of assessment
    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @Column(name = "duration")
    private Integer duration;

    @Column(name = "marks", precision = 22, scale = 6)
    private double marks; // scored by candidate
    @Column(name = "max_score", precision = 22, scale = 6)
    private double maxScore;
    @Column(name = "passing_score", precision = 22, scale = 6)
    private double passingScore;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
