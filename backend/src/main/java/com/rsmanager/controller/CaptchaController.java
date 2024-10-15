package com.rsmanager.controller;

import com.rsmanager.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/captcha")
    public Map<String, String> getCaptcha() {
        // 生成验证码文本
        String captchaText = captchaService.generateCaptchaText();
        // 生成 Base64 编码的图片
        String captchaImage = captchaService.generateCaptchaImage(captchaText);

        // 返回验证码文本和图片给前端（文本通常用于在服务端校验）
        Map<String, String> response = new HashMap<>();
        response.put("captchaText", captchaText);
        response.put("captchaImage", captchaImage);

        return response;
    }
}
