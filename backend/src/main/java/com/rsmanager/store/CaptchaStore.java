package com.rsmanager.store;

import com.rsmanager.service.CaptchaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CaptchaStore {
    private ConcurrentHashMap<String, CaptchaService.Captcha> captchaMap = new ConcurrentHashMap<>();

    public void storeCaptcha(CaptchaService.Captcha captcha) {
        captchaMap.put(captcha.getToken(), captcha);
    }

    public CaptchaService.Captcha getCaptcha(String token) {
        return captchaMap.get(token);
    }

    public void removeCaptcha(String token) {
        captchaMap.remove(token);
    }

    // 定时任务每10分钟清理一次验证码
    @Scheduled(fixedRate = 600000)
    public void cleanUp() {
        Instant now = Instant.now();
        captchaMap.entrySet().removeIf(entry -> {
            // 假设验证码有效期为10分钟
            return now.minusSeconds(600).isAfter(entry.getValue().getCreationTime());
        });
    }
}
