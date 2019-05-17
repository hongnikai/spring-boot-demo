package com.lc.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * @author Nick
 * @version V1.0.0
 * @Date 2017/12/2 22:06
 * @description 分布式Session，使用spring.session.store-type=redis自动配置
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 1800)
public class SessionConfig {

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }


}
