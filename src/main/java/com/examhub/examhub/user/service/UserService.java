package com.examhub.examhub.user.service;

import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.common.dto.SearchResponseTO;
import com.examhub.examhub.user.dto.UserTO;
import java.util.List;

public interface UserService {
    UserTO createUser(UserTO userTO);
    UserTO updateUser(UserTO userTO);
    boolean deleteUser(Integer id);
    UserTO findUserById(Integer id);
    SearchResponseTO<UserTO> searchUser(SearchRequestTO searchRequest);
}
