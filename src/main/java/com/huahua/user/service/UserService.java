package com.huahua.user.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    public void addUser(Map par);
    public List<Map<String, Object>> userList(Map<String, Object> par);
    public Integer delById(String id);
}
