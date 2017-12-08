package com.example.oauth2.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.oauth2.domain.SysUser;
import com.example.oauth2.service.SysUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
	@Autowired
	private SysUserService sysUserService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	if (StringUtils.isBlank(username)) {
			throw new UsernameNotFoundException("用户名不能为空");
		}
		SysUser sysUser = sysUserService.getByUsername(username);
		if(sysUser==null) {
			throw new UsernameNotFoundException("该用户不存在");
		}
    	
    	List<String> roles = new ArrayList<String>();
        Set<GrantedAuthority> authorities = new HashSet<>();
        
        roles.add("ROLE_user");
        roles.add("ROLE_vip");
        roles.add("ROLE_admin");
        
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        User user = new User(username, sysUser.getPassword(), authorities);
        
        return user;
    }
    
}
