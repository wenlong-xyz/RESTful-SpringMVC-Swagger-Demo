package pers.well.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pers.well.service.AuthService;


/**
 * 自定义拦截器，判断此次请求是否有权限
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	private static final String TOKEN = "token";
	private static final String NAME = "name";
	@Autowired
	protected AuthService authService;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //从参数中得到name
        String name = request.getParameter(NAME);
        //从参数中得到token
        String token = request.getParameter(TOKEN);
        
        if(token != null && name != null && authService.tokenCheck(name, token)){
        	return true;
        }
        else{
        	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
