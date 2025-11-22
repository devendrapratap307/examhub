package com.examhub.examhub.exam.service;

import com.examhub.examhub.common.config.MapperService;
import com.examhub.examhub.common.dto.CommonListTO;
import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.common.dto.SearchResponseTO;
import com.examhub.examhub.common.util.UtilService;
import com.examhub.examhub.exam.dao.ExamDao;
import com.examhub.examhub.exam.dto.AssessmentTO;
import com.examhub.examhub.exam.model.AssessmentBO;
import com.examhub.examhub.user.dto.UserTO;
import com.examhub.examhub.user.model.UserBO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public SearchResponseTO<AssessmentTO> searchAssessment(SearchRequestTO searchRequestTO) {
        List<AssessmentTO> assessmentList = new ArrayList<>();
        SearchResponseTO response = new SearchResponseTO();
        CommonListTO<AssessmentBO> assessmentData = this.examDao.searchAssessment(searchRequestTO);
        if(UtilService.checkNull(assessmentData) && UtilService.checkNull(assessmentData.getDataList())){
            assessmentList =  mapperService.map(assessmentData.getDataList(), AssessmentTO.class);
        }
        response.setList(assessmentList);
        response.setPage(assessmentData.getPageCount());
        response.setTotal(assessmentData.getTotalRow().intValue());
        return response;
    }
}
