package com.lc.controller;

import com.lc.service.UserService;
import com.lc.util.JavaLinux;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
* @Author create by lc 2018-8-30
* */
@SuppressWarnings("all")
@RestController
@Scope(value="prototype")
@RequestMapping("/bootController")
public class BootController {

    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void demo(){

        //日志的级别：
        //由低到高
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        //spring boot 默认使用的是info级别的
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是异常日志");


    }


    @RequestMapping("/test")
    public Object test(
                       ){
//        Map<String,Object> map2 = userService.selectAllUser();
        JavaLinux javaLinux =new JavaLinux();
        javaLinux.gotoShell();
        return "结束";
    }

    @RequestMapping("/selectPriceInnerJoinPOrder")
    public Object selectPriceInnerJoinPOrder(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("open_id","oOqee4nUTLUTsND0RFWvP1Tmy7BY");
        map.put("num",1);
        return  userService.selectAllUser();
    }



}
