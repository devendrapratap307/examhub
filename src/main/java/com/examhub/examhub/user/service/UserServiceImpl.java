package com.examhub.examhub.user.service;

import com.examhub.examhub.common.config.MapperService;
import com.examhub.examhub.user.dao.UserDao;
import com.examhub.examhub.user.dto.UserTO;
import com.examhub.examhub.user.model.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Autowired
    private MapperService mapperService;


    @Override
    public UserTO createUser(UserTO userTO) {
        UserBO user = userDao.createUser(mapperService.map(userTO, UserBO.class));
        return mapperService.map(user, UserTO.class);
    }

    @Override
    public UserTO updateUser(UserTO userTO) {
        UserBO user = userDao.updateUser(mapperService.map(userTO, UserBO.class));
        return mapperService.map(user, UserTO.class);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public UserTO findUserById(String id) {
        UserBO user = userDao.findUserById(id);
        return mapperService.map(user, UserTO.class);
    }

    @Override
    public List<UserTO> searchUser(String name) {
        return List.of();
    }

}
