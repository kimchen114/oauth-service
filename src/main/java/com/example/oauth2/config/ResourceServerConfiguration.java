//package com.example.oauth2.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
///**
// * 资源服务端
// * 
// * @author chenjinwei
// *
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//	
//    @Override  
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {  
//        resources.resourceId("my_resource_id");  
//    }  
//    @Override  
//    public void configure(HttpSecurity http) throws Exception {  
//        http.authorizeRequests()  
//            .antMatchers("/oauth/**","/login/**").permitAll();
//    } 
//}