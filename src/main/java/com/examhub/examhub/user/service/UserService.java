package com.examhub.examhub.user.service;

import com.examhub.examhub.user.dto.UserTO;
import java.util.List;

public interface UserService {
    UserTO createUser(UserTO userTO);
    UserTO updateUser(UserTO userTO);
    boolean deleteUser(Integer id);
    UserTO findUserById(String id);
    List<UserTO> searchUser(String name);
}
