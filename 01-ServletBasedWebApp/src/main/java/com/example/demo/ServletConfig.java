package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    
    @Bean
    public ServletRegistrationBean<HelloServlet> helloServlet() {
        ServletRegistrationBean<HelloServlet> registrationBean = 
            new ServletRegistrationBean<>();
        
        registrationBean.setServlet(new HelloServlet());
        registrationBean.addUrlMappings("/hello");
        registrationBean.setLoadOnStartup(1);
        
        return registrationBean;
    }
}