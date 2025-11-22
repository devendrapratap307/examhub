package com.examhub.examhub.exam.service;

import com.examhub.examhub.common.config.MapperService;
import com.examhub.examhub.exam.dao.ExamDao;
import com.examhub.examhub.exam.dto.AssessmentTO;
import com.examhub.examhub.exam.model.AssessmentBO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExamServiceImpl implements ExamService{
    @Autowired
    private ExamDao examDao;

    @Autowired
    private MapperService mapperService;

    @Override
    public AssessmentTO createAssessment(AssessmentTO assessment) {
        AssessmentBO assessmentReturn = this.examDao.createAssessment(mapperService.map(assessment, AssessmentBO.class));
        return mapperService.map(assessmentReturn, AssessmentTO.class);
    }

    @Override
    public AssessmentTO updateAssessment(AssessmentTO assessment) {
        AssessmentBO assessmentReturn = this.examDao.updateAssessment(mapperService.map(assessment, AssessmentBO.class));
        return mapperService.map(assessmentReturn, AssessmentTO.class);
    }

    @Override
    public boolean deleteAssessment(Integer id) {
        return this.examDao.deleteAssessment(id);
    }

    @Override
    public AssessmentTO fetchAssessment(Integer id) {
        AssessmentBO assessmentReturn = this.examDao.fetchAssessment(id);
        return mapperService.map(assessmentReturn, AssessmentTO.class);
    }

    @Override
    public List<AssessmentTO> searchAssessment() {
        List<AssessmentBO> assessmentList = this.examDao.searchAssessment();
        return mapperService.map(assessmentList, AssessmentTO.class);
    }
}
