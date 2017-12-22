package com.example.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 认证服务器
 * 
 * */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    
		@Autowired
	    private UserDetailsServiceImpl userDetailsServiceImpl;
		
	    @Override
	    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	        clients.inMemory().withClient("client").secret("secret")
	                .scopes("FOO").autoApprove(true)
	                .authorities("FOO_READ", "FOO_WRITE")
	                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code")
	                .accessTokenValiditySeconds(60*60).refreshTokenValiditySeconds(60*60*10);
	    }

	    @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	    	endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST);
	        endpoints.tokenStore(tokenStore()).tokenEnhancer(jwtTokenEnhancer())
	                .authenticationManager(authenticationManager).userDetailsService(userDetailsServiceImpl);
	    }

	    @Autowired
	    @Qualifier("authenticationManagerBean")
	    private AuthenticationManager authenticationManager;

	    @Bean
	    public TokenStore tokenStore() {
	        return new JwtTokenStore(jwtTokenEnhancer());
	    }

	    //    @Bean
	    //    protected JwtAccessTokenConverter jwtTokenEnhancer() {
	    //    KeyStoreKeyFactory keyStoreKeyFactory =
	    //            new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "mySecretKey".toCharArray());
	    //        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    //        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
	    //        return converter;
	    //    }

	    @Bean
	    protected JwtAccessTokenConverter jwtTokenEnhancer() {
	        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	        converter.setSigningKey("123");
	        return converter;
	    }
    
}
