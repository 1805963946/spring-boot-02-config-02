package com.huahua.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserDao {
    public Integer addUser(Map<String, Object> par);
}
