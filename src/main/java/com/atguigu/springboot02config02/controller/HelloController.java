package com.atguigu.springboot02config02.controller;

import com.atguigu.springboot02config02.mybatais.Caidan;
import com.atguigu.springboot02config02.mybatais.TestDao;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@Controller
public class HelloController {

    @Autowired
    TestDao testDao;

    @RequestMapping("/ajaxLogin")
    @ResponseBody
    public Object ajaxLogin(HttpServletRequest request) {
        Map<String, Object> returnMap = new HashMap<>();
        List<Map<String, Object>> user = testDao.getEmpById(request.getParameter("username"));
        if (user.size() == 0) {
            returnMap.put("code", "1");
            returnMap.put("message", "账号不存在");
            return returnMap;
        }
        String password = request.getParameter("psw");
        if (!user.get(0).get("psw").equals(password)) {
            returnMap.put("code", "1");
            returnMap.put("message", "密码错误");
            return returnMap;
        }
        returnMap.put("code", "0");
        returnMap.put("message", "登录成功");

        request.getSession().setAttribute("userInfo", user.get(0));
        return returnMap;
    }


    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Object getLoginInfo(HttpServletRequest request) {
        return request.getSession().getAttribute("userInfo");
    }


    @Autowired
    Caidan caidan;

    @RequestMapping("/inde")
    @ResponseBody
    public Object index(HttpServletRequest request ) throws JSONException {
        Map<String,Object> user = (Map<String, Object>) request.getSession().getAttribute("userInfo");
        int id = (int)user.get("id");
        List<Map<String, Object>> data = caidan.getcaidan(id);
        List<Map<String, Object>> returnMap = new ArrayList<>();
        for (Map<String, Object> m : data) {//每一个菜单都有孩子,只不过孩子可能是0个或者多个
            m.put("child", new ArrayList<Map<String, Object>>());
        }
        for (Map<String, Object> m : data) {//开始遍历找孩子
            if (m.get("pid") == null) {//如果没有父亲他自己就是顶级节点就不用找父亲了
                returnMap.add(m);//他如果是顶级节点就直接放到返回的那个map里面
                continue;
            }
            for (Map<String, Object> m1 : data) {//到了这里表示不是顶级节点,需要找父亲
                if (m.get("pid") == m1.get("id")) {//如果找到了父亲就把自己和父亲简历关系,简历关系就是把自己放到父亲的child这个属性里面
                    ((List) m1.get("child")).add(m);
                }
            }
        }
        return returnMap;
    }
}
