package com.esvr.retobcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.esvr")
public class RetobcpApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RetobcpApplication.class, args);
	}

}
