package com.lc.config;

import com.lc.component.LoginHandlerInterceptor;
import com.lc.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置类   对应  LoginHandlerInterceptor
 * 普通拦截器拦截所有请求,在redis session共享阶段先注释掉@Configuration注解
 * @author lc
 */
//@Configuration
public class MyMvcConfig2 implements WebMvcConfigurer{


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/lc").setViewName("success");
        registry.addViewController("/").setViewName("index");  //第二种跳转主页方法
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //拦截器
    //不拦截 resources文件夹下的  public、static、resources 文件夹下的资源文件  除此之外都拦截
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/","/user/login","/static/**","/index.html"
//                       ,"/asserts/css/signin.css","/webjars/bootstrap/4.1.3/css/bootstrap.css"
///               ,"/asserts/img/bootstrap-solid.svg");
//
//
//    }


    //国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
