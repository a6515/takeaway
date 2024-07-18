package com.example.takeawaypro.interceptors;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.takeawaypro.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.util.Map;

@Component
public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查是否是 OPTIONS 请求，如果是则放行
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            System.out.println("Method: OPTIONS");
            return true;
        }

        String token = request.getHeader("Authorization");
        System.out.println("从前端获取到的 token 的值为: " + token);

        try {
            // 解析 JWT token，获取其中的声明（claims）
            Map<String, Object> claims = JwtUtils.parseToken(token);
            return true;  // 验证通过，继续处理请求
        } catch (TokenExpiredException e) {
            // 处理 token 过期异常
            response.setStatus(998);
            System.out.println("Token 已过期: " + e.getMessage());
            return false;  // 停止继续处理请求
        }
        catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }
}