package com.jsp.spring.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jsp.spring.annotations")
public class AppConfig {

}

//No need to spring.xml file
// In case of sub package we don't need give multiple package but we can give like @ComponentScan({"com.jsp.spring.annotations","com.jsp.spring.annotations.entity"})