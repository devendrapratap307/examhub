package com.examhub.examhub.user.dao;

import com.examhub.examhub.common.dto.CommonListTO;
import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.user.model.UserBO;
import java.util.List;

public interface UserDao {
    UserBO createUser(UserBO userBO);
    UserBO updateUser(UserBO userBO);
    boolean deleteUser(Integer id);
    UserBO findUserById(Integer id);
    CommonListTO<UserBO> searchUser(SearchRequestTO searchRequest);
}
