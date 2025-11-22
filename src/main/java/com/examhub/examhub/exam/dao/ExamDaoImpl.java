package com.examhub.examhub.exam.dao;

import com.examhub.examhub.common.constant.APP_CONST;
import com.examhub.examhub.common.dto.CommonListTO;
import com.examhub.examhub.common.dto.SearchFieldsTO;
import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.common.util.UtilService;
import com.examhub.examhub.exam.model.AssessmentBO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
        if(id==null){
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<AssessmentBO> update = builder.createCriteriaUpdate(AssessmentBO.class);
            Root<AssessmentBO> root = update.from(AssessmentBO.class);
            update.set("status", APP_CONST.STATUS.DELETED);
            update.where(builder.equal(root.get("id"), id));
            entityManager.createQuery(update).executeUpdate();
        }
        return false;
    }

    @Override
    public AssessmentBO fetchAssessment(Integer id) {
        return entityManager.find(AssessmentBO.class, id);
    }

    @Override
    public CommonListTO<AssessmentBO> searchAssessment(SearchRequestTO searchRequest) {
        SearchFieldsTO searchFieldsObj = searchRequest.getSearchFields();
        SimpleDateFormat dateFormat = new SimpleDateFormat(APP_CONST.DATE_FORMAT);

        CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AssessmentBO> criteriaQuery = queryBuilder.createQuery(AssessmentBO.class);
        Root<AssessmentBO> entityRoot = criteriaQuery.from(AssessmentBO.class);
        ArrayList<Predicate> searchFilter = new ArrayList<>();

        if (searchRequest.getSearchFields() != null) {
            // Filter for entity fields ...
            ArrayList<Predicate> fieldsFilter = new ArrayList<>();
            if (searchFieldsObj.getSearchFor() != null && !searchFieldsObj.getSearchFor().isEmpty()) {
                Path<String> e1 = entityRoot.get("title");
                fieldsFilter.add(queryBuilder.like(e1, "%" + searchFieldsObj.getSearchFor() + "%"));
                fieldsFilter.add(queryBuilder.like(entityRoot.get("description"), "%" + searchFieldsObj.getSearchFor() + "%"));
            }

            if (UtilService.checkNull(fieldsFilter)) {
                searchFilter.add(queryBuilder.or(fieldsFilter.toArray(new Predicate[0])));
            }
            if(UtilService.checkNull(searchFieldsObj.getAssessmentType())) {
                searchFilter.add(queryBuilder.equal(entityRoot.get("assessmentType"), searchFieldsObj.getAssessmentType()));
            }
            if(UtilService.checkNull(searchFieldsObj.getRecruiterId())) {
                searchFilter.add(queryBuilder.equal(entityRoot.get("recruiterId"), searchFieldsObj.getRecruiterId()));
            }
        }
        searchFilter.add(queryBuilder.equal(entityRoot.get("status"), APP_CONST.STATUS.ACTIVE));

        criteriaQuery.where(searchFilter.toArray(new Predicate[0]));
        TypedQuery<AssessmentBO> query = entityManager.createQuery(criteriaQuery);
        // Condition for paging.
        CommonListTO<AssessmentBO> data = new CommonListTO<>();
        // Adding Pagination total Count
        CriteriaQuery<Long> criteriaCountQuery = queryBuilder.createQuery(Long.class);
        criteriaCountQuery.where(searchFilter.toArray(new Predicate[0]));
        Root<AssessmentBO> entityRootCount = criteriaCountQuery.from(AssessmentBO.class);
        CriteriaQuery<Long> select = criteriaCountQuery.select(queryBuilder.count(entityRootCount));
        Long count = entityManager.createQuery(select).getSingleResult();
        data.setTotalRow(count);
        int size = count.intValue();
        int limit = searchRequest.getLimit();
        if (limit != 0) {
            data.setPageCount((size + limit - 1) / limit);
        } else {
            data.setPageCount(1);
        }
        // Condition for paging.
        if (searchRequest.getPage() != 0 && searchRequest.getLimit() > 0) {
            query.setFirstResult((searchRequest.getPage() - 1) * searchRequest.getLimit());
            query.setMaxResults(searchRequest.getLimit());
        }
        data.setDataList(query.getResultList());
        return data;
    }
}
