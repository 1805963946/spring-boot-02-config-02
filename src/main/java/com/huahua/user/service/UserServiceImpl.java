package com.huahua.user.service;

import com.huahua.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(rollbackFor = java.lang.Exception.class)
    public void addUser(Map par) {
        Integer i = userDao.addUser(par);
        if (i == 0) {
            throw new RuntimeException("新增失败");
        }
    }
}
