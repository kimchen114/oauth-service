package com.example.oauth2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
	  Logger log = LoggerFactory.getLogger(WebSecurityConfiguration.class);
	    @Autowired
	    private UserDetailsServiceImpl userDetailsServiceImpl;
	    
	    
	    
	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        //        http.csrf().disable().exceptionHandling().authenticationEntryPoint(
	        //                (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
	        //                .authorizeRequests().antMatchers("/**").authenticated().and().httpBasic();
//	        super.configure(http);
	        
	        http.csrf().disable().headers().disable().authorizeRequests()
	        .antMatchers("/login/**", "/js/**", "/css/**", "/img/**", "/oauth/**", "/oauth/token",
	                "oauth/authorize")
	        .permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
	        .permitAll()//.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        // .failureUrl("/login").successHandler(successHandler)
	        .and().logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("token");
	        
	        
	        
	        
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication().withUser("reader").password("reader").authorities("FOO_READ").and()
	                .withUser("writer").password("writer").authorities("FOO_READ", "FOO_WRITE");

	                auth.userDetailsService(userDetailsServiceImpl);
	    }
    
}
