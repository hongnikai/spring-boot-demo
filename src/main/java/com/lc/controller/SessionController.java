package com.lc.controller;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sessionController")
public class SessionController {



    @RequestMapping("/setSession")
    public Object setSession(HttpServletRequest request){

        request.getSession().setAttribute("liuce", "session");

        return "set";
    }

    @RequestMapping("/getSession")
    public Object getSession(HttpServletRequest request){
//        Session session = (Session) request.getSession();
        String id = request.getSession().getId();
        Object attr = request.getSession().getAttribute("liuce");
        Object attrName = request.getSession().getAttributeNames();
        return request.getSession().getAttribute("liuce");
    }


}
