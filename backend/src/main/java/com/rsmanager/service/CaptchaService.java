package com.rsmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.fessional.kaptcha.KaptchaProducer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class CaptchaService {

    @Autowired
    private KaptchaProducer kaptchaProducer;

    @Autowired
    private CaptchaStore captchaStore;

    // 生成验证码
    public Captcha generateCaptcha() throws IOException {
        String token = UUID.randomUUID().toString();
        String text = kaptchaProducer.createText();
        ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
        kaptchaProducer.createImage(text, imageStream);
        byte[] imageBytes = imageStream.toByteArray();

        Captcha captcha = new Captcha(token, text, imageBytes);
        captchaStore.storeCaptcha(captcha);
        return captcha;
    }

    // 验证验证码
    public boolean validateCaptcha(String token, String userInput) {
        Captcha storedCaptcha = captchaStore.getCaptcha(token);
        if (storedCaptcha == null) {
            return false;
        }
        boolean isValid = storedCaptcha.getText().equalsIgnoreCase(userInput);
        captchaStore.removeCaptcha(token); // 验证后移除验证码
        return isValid;
    }

    // Captcha 模型
    public static class Captcha {
        private String token;
        private String text;
        private byte[] image;

        public Captcha(String token, String text, byte[] image) {
            this.token = token;
            this.text = text;
            this.image = image;
        }

        public String getToken() {
            return token;
        }

        public String getText() {
            return text;
        }

        public byte[] getImage() {
            return image;
        }
    }
}
