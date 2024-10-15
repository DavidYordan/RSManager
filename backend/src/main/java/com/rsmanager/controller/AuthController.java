package com.rsmanager.controller;

import com.rsmanager.security.JwtTokenUtil;
import com.rsmanager.security.CustomUserDetails;
import com.rsmanager.model.LoginRequest;
import com.rsmanager.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {

        // 验证验证码
        String captchaInSession = (String) session.getAttribute("captcha");
        if (captchaInSession == null || !captchaInSession.equalsIgnoreCase(loginRequest.getCaptchaCode())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("验证码错误");
        }
        // 验证后从会话中移除验证码
        session.removeAttribute("captcha");

        try {
            // 认证用户
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
                )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 生成令牌
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String token = jwtTokenUtil.generateToken(userDetails);

            // 返回令牌和用户角色
            return ResponseEntity.ok(new LoginResponse(token, userDetails.getUser().getRole().getName()));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
        }
    }
}
