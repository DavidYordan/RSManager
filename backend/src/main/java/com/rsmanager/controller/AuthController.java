package com.rsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private CaptchaService captchaService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("captcha") String captchaInput,
                        @RequestParam("captchaToken") String captchaToken,
                        Model model) {
        boolean isCaptchaValid = captchaService.validateCaptcha(captchaToken, captchaInput);
        if (!isCaptchaValid) {
            model.addAttribute("error", "验证码验证失败，请重试。");
            return "login";
        }

        // 进行用户认证逻辑（使用 Spring Security）
        // 可以触发 Spring Security 的认证流程或自定义认证逻辑

        return "redirect:/home";
    }
}
