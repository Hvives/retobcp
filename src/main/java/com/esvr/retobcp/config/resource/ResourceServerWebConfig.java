package com.esvr.retobcp.config.resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan({ "com.esvr.retrobcp.web" })
public class ResourceServerWebConfig implements WebMvcConfigurer {


}
