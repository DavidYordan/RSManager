package com.rsmanager.service;

import com.github.cage.Cage;
import com.github.cage.GCage;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class CaptchaService {

    private final Cage cage = new GCage();

    /**
     * 生成验证码文本
     * @return 随机生成的验证码字符串
     */
    public String generateCaptchaText() {
        return cage.getTokenGenerator().next();
    }

    /**
     * 生成 Base64 编码的验证码图片
     * @param captchaText 验证码文本
     * @return Base64 编码的图片
     */
    public String generateCaptchaImage(String captchaText) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            cage.draw(captchaText, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // 将生成的图片转换为 Base64 字符串
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
