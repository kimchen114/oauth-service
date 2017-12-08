package com.example.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration 
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter  {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private  LoginSuccessHandler successHandler;
    
    

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("reader").password("reader").authorities("FOO_READ").and()
              	.withUser("writer").password("writer").authorities("FOO_READ", "FOO_WRITE");

      	  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	  }   
    
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	 http.csrf().disable().headers().disable().authorizeRequests()
// 	    .antMatchers("/login/**","/js/**","/css/**","/img/**","/oauth/**","/oauth/token","oauth/authorize").permitAll()
// 	    .anyRequest().authenticated() 
// 	    .and()
// 	    .formLogin().loginPage("/login").passwordParameter("password").usernameParameter("username").permitAll()
//	    .failureUrl("/login").successHandler(successHandler)
//	    .and()
//	    .logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("token");
//    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
    
    
    
    
}
