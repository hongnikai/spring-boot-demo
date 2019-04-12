package com.lc.controller;

import com.lc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class ThymeleafController {


    private UserService userService;

    @RequestMapping("/ttt")
    public Object ttt(Map<String,Object> map){

        map.put("hello","你好");
        map.put("users", Arrays.asList("张三","李四","王五"));

        //默认在templates  文件加下
        return "success";
    }

    @RequestMapping("/ttt2")
    public String ttt2(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String, Object>();

        map.put("hello","<h1>你好</h1>");
        map.put("users",Arrays.asList("张三","李四","王五"));

        request.setAttribute("map",map);

        return "success2";
    }

    @RequestMapping("/ttt3")
    public String ttt3(HttpServletRequest request){
//
//        map.put("hello","你好");
//        map.put("users",Arrays.asList("张三","李四","王五"));


        request.setAttribute("list",Arrays.asList("张三","李四","王五"));
        return "success3";
    }

}
