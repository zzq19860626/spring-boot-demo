package com.zjp.test.server.service;

import com.zjp.test.common.UserDomain;
import com.zjp.test.server.dao.entiry.User;
import com.zjp.test.server.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public UserDomain findById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        UserDomain domain = new UserDomain();
        domain.setId(user.getId());
        domain.setUserName(user.getName());
        return domain;
    }
}
