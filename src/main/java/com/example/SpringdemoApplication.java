package com.example;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//exclude = {DataSourceAutoConfiguration.class}
@SpringBootApplication()
@ComponentScan({"com.example.*"})
@MapperScan({"com.example.dao.mapper"})
//@EnableScheduling
@EnableCaching
@EnableDiscoveryClient
@Logger
public class SpringdemoApplication {
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}


	@RequestMapping(value = "/getLogLevel", method = RequestMethod.GET)
	public String testLogLevel() {
		logger.debug("Logger Level ：DEBUG");
		logger.info("Logger Level ：INFO");
		logger.error("Logger Level ：ERROR");
		return "";
	}
}
