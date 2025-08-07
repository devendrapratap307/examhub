package com.examhub.examhub.exam.dao;

import com.examhub.examhub.exam.model.AssessmentBO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ExamDaoImpl implements ExamDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public AssessmentBO createAssessment(AssessmentBO assessment) {
        entityManager.persist(assessment);
        return null;
    }

    @Override
    public AssessmentBO updateAssessment(AssessmentBO assessment) {
        return entityManager.merge(assessment);
    }

    @Override
    public boolean deleteAssessment(Integer id) {
        return false;
    }

    @Override
    public AssessmentBO fetchAssessment(Integer id) {
        return entityManager.find(AssessmentBO.class, id);
    }

    @Override
    public List<AssessmentBO> searchAssessment() {
        return null;
    }
}
