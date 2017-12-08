package com.example.oauth2.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

@Service
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final static Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);
    private final static int COOKIESSAVETIME = 60 * 60 * 1; //cookie有效时长为一天

//    @Autowired
//    private SysUserService sysUserService;

    //登录成功后执行该方法
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("LoginSuccess: {}", authentication);
        }
//		Map<String, Object> claims = new HashMap<String, Object>();
//		authentication.getName();
//		UserDetail userDetail =(UserDetail) authentication.getPrincipal();
//		claims.put("username", userDetail.getUsername());
//		claims.put("userId", userDetail.getUserId());
//		claims.put("password", userDetail.getPassword());
//		String token = JWTUtil.generateToken(claims);
//		System.err.println(token);
////        HttpSession session = request.getSession();
//        Cookie tokenCookie = new Cookie("token",token);
//        tokenCookie.setMaxAge(COOKIESSAVETIME);
//        response.addCookie(tokenCookie);
//        SysUser sysUser = new SysUser();
//        sysUser.setId(userDetail.getUserId());
//        sysUser.setToken(token);
//        sysUser.setGmtModified(new Date());
//        sysUserService.update(sysUser);
        	response.sendRedirect("/index");
//        response.setHeader("", "");
        
        
        
        return;
    }
}
