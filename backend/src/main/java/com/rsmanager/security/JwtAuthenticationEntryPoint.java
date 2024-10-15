package com.rsmanager.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
        HttpServletRequest request,
        HttpServletResponse response,
        AuthenticationException authException) throws IOException, ServletException {
        // 当用户尝试访问受保护的 REST 资源而不提供凭据时调用
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未授权");
    }
}
