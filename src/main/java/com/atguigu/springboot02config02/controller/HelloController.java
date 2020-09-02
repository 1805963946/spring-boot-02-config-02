package com.atguigu.springboot02config02.controller;

import com.atguigu.springboot02config02.mybatais.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Controller
public class HelloController {

    @Autowired
    TestDao testDao;

    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll() {
        return testDao.selectAll();
    }


    @RequestMapping("/test")
    @ResponseBody
    public Object testMbatis() {
        return testDao.getEmpById("xiao");
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public Object login(HttpServletRequest request,String username ){
//        List<Map<String,Object>> user =testDao.getEmpById(username);
//        if(user.size()==0){
//            return "用户不存在";
//        }String password =request.getParameter("psw");
//        if (!user.get(0).get("psw").equals(password)){
//            return "密码错误";
//        }
//        return user.get(0);
//    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username) {
        List<Map<String, Object>> user = testDao.getEmpById(username);
        if (user.size() == 0) {
            return "redirect:login/login.html";
        }
        String password = request.getParameter("psw");
        if (!user.get(0).get("psw").equals(password)) {
            return "redirect:login/login.html";
        }
        return "redirect:/index.html";
    }

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

        request.getSession().setAttribute("userInfo",user.get(0));
        return returnMap;
    }

    @RequestMapping("/testPar")
    @ResponseBody
    public Object testParam(HttpServletRequest request ){
        return request.getParameter("s1")+request.getParameter("s2");
    }

    @RequestMapping("/loginUser")
    @ResponseBody
    public Object loginUser(HttpServletRequest request ){
        return request.getSession().getAttribute("userInfo");
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Object getLoginInfo(HttpServletRequest request ){
        return request.getSession().getAttribute("userInfo");
    }

}
