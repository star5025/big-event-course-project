package org.star5025.bigevent.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.star5025.bigevent.utils.JwtUtil;
import org.star5025.bigevent.utils.ThreadLocalUtil;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            //将业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            return true;//放行
        } catch (Exception e) {
            response.setStatus(401);
            return false;//不放行
        }
    }
}
