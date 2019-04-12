package com.lc.config;

import com.lc.component.LoginHandlerInterceptor;
import com.lc.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//使用WebMvcConfigurerAdapter 可以拓展springMVC的功能
//@EnableWebMvc   使springboot默认配置的mvc 失效
//@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//        //浏览器发送/lc  请求即可直接访问success页面
//        registry.addViewController("/lc").setViewName("success");
//        registry.addViewController("/").setViewName("index");  //第二种跳转主页方法
//        registry.addViewController("/index.html").setViewName("index");
//    }

    //第三种
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
       // @Bean
        public WebMvcConfigurerAdapter WebMvcConfigurerAdapter(){
            WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("index");
                    registry.addViewController("/index.html").setViewName("index");
                    registry.addViewController("/main.html").setViewName("dashboard");
                }
                //扩展配置拦截器

                //注册拦截器
                @Override
                public void addInterceptors(InterceptorRegistry registry) {
                    //registry.addWebRequestInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**") 拦截所有请求

                    //静态资源  css js  springboot 不拦截

                    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                            .excludePathPatterns("/index.html","/","/user/login");


                    super.addInterceptors(registry);
                }
            };
            return adapter;
        }

        //区域信息解析器 构建@bean
      //  @Bean
        public LocaleResolver localeResolver(){
            return new MyLocaleResolver();
         }


}