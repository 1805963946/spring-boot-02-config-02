package com.huahua.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {
    public Integer addUser(Map<String, Object> par);

    public List<Map<String, Object>> userList(Map<String, Object> par);

    public Integer delById(@Param("id") String id);
}
