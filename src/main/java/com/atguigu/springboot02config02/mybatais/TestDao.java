package com.atguigu.springboot02config02.mybatais;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TestDao {
    public List<Map<String, Object>> getEmpById(@Param("username")String username);

    public List<Map<String, Object>> selectAll();
}
