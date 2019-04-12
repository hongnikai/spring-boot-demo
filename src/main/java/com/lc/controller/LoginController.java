package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

     //@GetMapping  ==  @RequestMapping(value = "/user/login",method = RequestMethod.GET)
     //@PostMapping ==  @RequestMapping(value = "/user/login",method = RequestMethod.POST)
     @PostMapping(value = "/user/login")
     public String login(@RequestParam("username")String username,@RequestParam("password")String password,
                         Map<String,Object> map,HttpSession session
                         ){
        if (!StringUtils.isEmpty(username)&& "123456".equals(password)){
            session.setAttribute("loginUser",username);
            //登陆成功，防止表单重复提交，重定向到主页
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名密码错误");
            return "index";
        }

     }

     @GetMapping("login")
     public String login2(){
         return "index";
     }

     @RequestMapping("toIndex")
    public String toIndex(){

         return "index";
     }
}
