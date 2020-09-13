package com.huahua.user.controller;

import com.huahua.user.dao.UserDao;
import com.huahua.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    UserDao userDao;

    @RequestMapping("/addUser")
    @ResponseBody
    public Object addUser(HttpServletRequest hsr) {
        try {
            Map<String, Object> par = parToMap(hsr);
            userService.addUser(par);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }



    @RequestMapping("/userList")
    @ResponseBody
    public Object userList(HttpServletRequest hsr) {
        return userService.userList(parToMap(hsr));
    }


    @RequestMapping("/user/delById/{id}")
    @ResponseBody
    public Object delById(@PathVariable("id") String id) {
        return userService.delById(id);
    }


    @RequestMapping("/xiugai")
    @ResponseBody
    public Object xiugaipsw(HttpServletRequest hsr) {
        try {
            userService.xiugaipsw(parToMap(hsr));
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /***
     * 把HttpServletRequest 里面的参数转化为map
     *例  a=1,b=2 转化为{a:1,b:2}
     * @param hsr
     * @return
     */
    public static Map<String, Object> parToMap(HttpServletRequest hsr) {
        Map<String, Object> retMap = new HashMap<>();
        Map<String, String[]> parMap = hsr.getParameterMap();
        parMap.forEach((k, v) -> {
            retMap.put(k, v[0]);
        });

        return retMap;
    }

    @RequestMapping("/message")
    @ResponseBody
    public Object message(HttpServletRequest hsr) {
        return userService.message(parToMap(hsr));
    }
}
