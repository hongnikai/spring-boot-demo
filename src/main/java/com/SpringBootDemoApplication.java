package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

//
@SpringBootApplication/*(exclude = DataSourceAutoConfiguration.class)*/
//@MapperScan("com.lc.dao")
public class SpringBootDemoApplication {
	private final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);

	@Autowired
	@Qualifier("datasourceOne")
	private DataSource dataSource;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	public void run(String... strings) throws Exception {
		logger.info("项目使用的dataSource为:{}", dataSource);
	}
}
