package com.examhub.examhub.user.dao;

import com.examhub.examhub.common.constant.APP_CONST;
import com.examhub.examhub.common.dto.CommonListTO;
import com.examhub.examhub.common.dto.SearchFieldsTO;
import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.common.util.UtilService;
import com.examhub.examhub.user.model.UserBO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserBO createUser(UserBO userBO) {
        entityManager.persist(userBO);
        return userBO;
    }

    @Override
    public UserBO updateUser(UserBO userBO) {
        return entityManager.merge(userBO);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public UserBO findUserById(Integer id) {
        return entityManager.find(UserBO.class, id);
    }

    @Override
    public CommonListTO<UserBO> searchUser(SearchRequestTO searchRequest) {
        SearchFieldsTO searchFieldsObj = searchRequest.getSearchFields();
        SimpleDateFormat dateFormat = new SimpleDateFormat(APP_CONST.DATE_FORMAT);

        CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserBO> criteriaQuery = queryBuilder.createQuery(UserBO.class);
        Root<UserBO> entityRoot = criteriaQuery.from(UserBO.class);
        ArrayList<Predicate> searchFilter = new ArrayList<>();

        if (searchRequest.getSearchFields() != null) {
            // Filter for entity fields ...
            ArrayList<Predicate> fieldsFilter = new ArrayList<>();
            if (searchFieldsObj.getSearchFor() != null && !searchFieldsObj.getSearchFor().isEmpty()) {
                Path<String> e1 = entityRoot.get("name");
                fieldsFilter.add(queryBuilder.like(e1, "%" + searchFieldsObj.getSearchFor() + "%"));
                fieldsFilter.add(queryBuilder.like(entityRoot.get("email"), "%" + searchFieldsObj.getSearchFor() + "%"));
            }

            if (UtilService.checkNull(fieldsFilter)) {
                searchFilter.add(queryBuilder.or(fieldsFilter.toArray(new Predicate[0])));
            }
        }
        criteriaQuery.where(searchFilter.toArray(new Predicate[0]));
        // Condition for sorting.
//            Order order = queryBuilder.desc(entityRoot.get("spId"));
//            criteriaQuery.orderBy(order);

        TypedQuery<UserBO> query = entityManager.createQuery(criteriaQuery);
        // Condition for paging.
        CommonListTO<UserBO> data = new CommonListTO<>();
        // Adding Pagination total Count
        CriteriaQuery<Long> criteriaCountQuery = queryBuilder.createQuery(Long.class);
        criteriaCountQuery.where(searchFilter.toArray(new Predicate[0]));
        Root<UserBO> entityRootCount = criteriaCountQuery.from(UserBO.class);
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
