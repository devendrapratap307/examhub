package com.examhub.examhub.exam.service;

import com.examhub.examhub.common.dto.ResponseTO;
import com.examhub.examhub.exam.dto.AssessmentTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface ExamService {
     AssessmentTO createAssessment(AssessmentTO assessment);
    AssessmentTO updateAssessment(AssessmentTO assessment);
     boolean deleteAssessment(Integer id);
    AssessmentTO fetchAssessment(Integer id);
     List<AssessmentTO> searchAssessment();
}
