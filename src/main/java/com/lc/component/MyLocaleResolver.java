package com.lc.component;


import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//为了实现国际化
//区域信息解析器   添加到配置类里
public class MyLocaleResolver implements  org.springframework.web.servlet.LocaleResolver{
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
       String l= request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)){   //如果请求不为空，那带来了 区域的语言信息
         String[] spilt = l.split("_");
         locale = new Locale(spilt[0],spilt[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, @Nullable HttpServletResponse httpServletResponse, @Nullable Locale locale) {

    }
}
