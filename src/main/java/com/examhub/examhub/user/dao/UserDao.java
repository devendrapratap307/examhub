package com.examhub.examhub.user.dao;

import com.examhub.examhub.user.model.UserBO;
import java.util.List;

public interface UserDao {
    UserBO createUser(UserBO userBO);
    UserBO updateUser(UserBO userBO);
    boolean deleteUser(Integer id);
    UserBO findUserById(String id);
    List<UserBO> findAllUsers();
}
