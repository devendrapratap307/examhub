package com.examhub.examhub.exam.service;

import com.examhub.examhub.exam.dto.AssessmentTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExamServiceImpl implements ExamService{
    @Override
    public AssessmentTO createAssessment(AssessmentTO assessment) {
        return null;
    }

    @Override
    public AssessmentTO updateAssessment(AssessmentTO assessment) {
        return null;
    }

    @Override
    public boolean deleteAssessment(Integer id) {
        return false;
    }

    @Override
    public AssessmentTO fetchAssessment(Integer id) {
        return null;
    }

    @Override
    public List<AssessmentTO> searchAssessment() {
        return null;
    }
}
