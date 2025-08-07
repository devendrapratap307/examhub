package com.examhub.examhub.exam.dao;

import com.examhub.examhub.exam.dto.AssessmentTO;
import com.examhub.examhub.exam.model.AssessmentBO;

import java.util.List;

public interface ExamDao {
    AssessmentBO createAssessment(AssessmentBO assessment);
    AssessmentBO updateAssessment(AssessmentBO assessment);
    boolean deleteAssessment(Integer id);
    AssessmentBO fetchAssessment(Integer id);
    List<AssessmentBO> searchAssessment();
}
