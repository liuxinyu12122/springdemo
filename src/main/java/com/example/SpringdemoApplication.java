package com.example;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"com.example.*"})
@Logger
public class SpringdemoApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[0];
//		return
//				new  Class[] { WebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[0];
	}

	@Override
	protected String[] getServletMappings() {
		return new String[0];
	}
}
