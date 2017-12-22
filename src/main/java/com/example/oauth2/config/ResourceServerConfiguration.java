//package com.example.oauth2.config;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//import org.springframework.security.web.util.matcher.RequestMatcher;
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
//    @Autowired
//    DefaultTokenServices defaultTokenServices;
//    
//    
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId("my_resource_id");
//        resources.tokenServices(defaultTokenServices);
//    }
//    
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//      // @formatter:off
////      http.requestMatcher(new OAuthRequestedMatcher()).authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
////          .anyRequest().authenticated();
//      // @formatter:on
//        http.antMatcher("/user").authorizeRequests().anyRequest().authenticated();
//        
//        
//    }
//
////    private static class OAuthRequestedMatcher implements RequestMatcher {
////      public boolean matches(HttpServletRequest request) {
////        String auth = request.getHeader("Authorization");
////        // Determine if the client request contained an OAuth Authorization
////        boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
////        boolean haveAccessToken = request.getParameter("access_token") != null;
////        return haveOauth2Token || haveAccessToken;
////      }
////    }
//    
//    
////    @Bean
////    @Primary
////    public ResourceServerTokenServices defaultTokenServices() {
////      final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
////      defaultTokenServices.setTokenEnhancer(jwtAccessTokenConverter());
////      defaultTokenServices.setTokenStore(tokenStore());
////      return defaultTokenServices;
////    }
//    
//   
//    
//    
////    @Bean
////    public TokenStore tokenStore() {
////        return new JwtTokenStore(jwtAccessTokenConverter());
////    }
////    
////    @Bean
////    protected JwtAccessTokenConverter jwtAccessTokenConverter() {
////        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
////        converter.setSigningKey("123");
////        return converter;
////    }
////    
//    
//    
//    
//    
//    
//}