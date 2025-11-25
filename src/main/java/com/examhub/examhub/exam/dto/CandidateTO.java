package com.examhub.examhub.exam.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CandidateTO {
    private Integer id;
    private Integer recruiterId;    // related recruiter
    private String name;
    private String email;
    private String passcode;
    private String phone;
    private String status;
    List<CandidateAssessmentTO> assessments;

    private Integer createdBy;
    private Integer updatedBy;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
