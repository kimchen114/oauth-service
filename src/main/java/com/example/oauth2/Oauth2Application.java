package com.example.oauth2;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.oauth2.mapper")
public class Oauth2Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }
    
    
    @RequestMapping("/user")
    public Principal user(Principal principal) {
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("name", principal.getName());
        return principal;
    }
    
    @RequestMapping("/me")
    public Map<String, String> me() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "me");
        return map;
    }
    
}
