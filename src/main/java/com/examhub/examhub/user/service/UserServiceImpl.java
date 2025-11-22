package com.examhub.examhub.user.service;

import com.examhub.examhub.common.config.MapperService;
import com.examhub.examhub.common.dto.CommonListTO;
import com.examhub.examhub.common.dto.SearchRequestTO;
import com.examhub.examhub.common.dto.SearchResponseTO;
import com.examhub.examhub.common.util.UtilService;
import com.examhub.examhub.user.dao.UserDao;
import com.examhub.examhub.user.dto.UserTO;
import com.examhub.examhub.user.model.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserTO findUserById(Integer id) {
        UserBO user = userDao.findUserById(id);
        return mapperService.map(user, UserTO.class);
    }

    @Override
    public SearchResponseTO<UserTO> searchUser(SearchRequestTO searchRequest) {
        SearchResponseTO response = new SearchResponseTO();
        CommonListTO<UserBO> userData = this.userDao.searchUser(searchRequest);
        List<UserTO> userList = new ArrayList<>();
        if(UtilService.checkNull(userData) && UtilService.checkNull(userData.getDataList())){
            userList =  mapperService.map(userData.getDataList(), UserTO.class);
        }
        response.setList(userList);
        response.setPage(userData.getPageCount());
        response.setTotal(userData.getTotalRow().intValue());
        return response;
    }

}
