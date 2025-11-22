package com.examhub.examhub.user.dao;

import com.examhub.examhub.user.model.UserBO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
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
    public UserBO findUserById(String id) {
        return entityManager.find(UserBO.class,id);
    }

    @Override
    public List findAllUsers() {
//        return entityManager.createNamedQuery("UserBO.findAll").getResultList();
        return null;
    }
}
