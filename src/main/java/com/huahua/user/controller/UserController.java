package com.huahua.user.controller;

import com.atguigu.springboot02config02.mybatais.Caidan;
import com.atguigu.springboot02config02.mybatais.TestDao;
import com.atguigu.springboot02config02.util.MD5Utils;
import com.huahua.user.service.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.atguigu.springboot02config02.util.MD5Utils.stringToMD5;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/addUser")
    @ResponseBody
    public Object addUser(HttpServletRequest hsr) {
        try {
            Map<String, Object> par = parToMap(hsr);
            par.put("psw", MD5Utils.stringToMD5(par.get("psw") + ""));//把用户传递过来的明文转化为md5
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
}
