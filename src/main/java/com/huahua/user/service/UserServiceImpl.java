package com.huahua.user.service;

import com.huahua.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.security.Signature;
import java.util.List;
import java.util.Map;


@Service
public  class UserServiceImpl implements UserService {

    @Resource
    @Autowired
    UserDao userDao;
    private Signature request;


    @Override
    @Transactional(rollbackFor = java.lang.Exception.class)
    public void addUser(Map par) {
        Integer i = userDao.addUser(par);
        if (i == 0) {
            throw new RuntimeException("新增失败");
        }
    }



    @Transactional(rollbackFor = java.lang.Exception.class)
    public List<Map<String, Object>> userList(Map<String, Object> par) {
        if (par.get("begin") == null) {
            par.put("begin", 0);
        }
        if (par.get("pageSize") == null) {
           par.put("pageSize", 10);
        }
        return userDao.userList(par);
    }

    public Integer delById(String id){
        return userDao.delById(id);
    }

    @Override
    @Transactional(rollbackFor = java.lang.Exception.class)
    public void xiugaipsw(Map par) {
        Integer i = userDao.xiugaipsw(par);
        if (i == 0) {
            throw new RuntimeException("修改失败");
        }
    }

    @Transactional(rollbackFor = java.lang.Exception.class)
    public List<Map<String, Object>> message(Map<String, Object> par) {
        if (par.get("begin") == null) {
            par.put("begin", 0);
        }
        if (par.get("pageSize") == null) {
            par.put("pageSize", 10);
        }
        return userDao.message(par);
    }

}
