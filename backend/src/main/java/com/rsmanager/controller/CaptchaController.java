package com.rsmanager.controller;

import com.github.cage.Cage;
import com.github.cage.GCage;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import jakarta.servlet.http.HttpSession;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class CaptchaController {

    private final Cage cage = new GCage();

    @GetMapping("/captcha")
    public ResponseEntity<byte[]> getCaptcha(HttpSession session) {
        // 生成验证码文本
        String token = cage.getTokenGenerator().next();
        // 将验证码文本存储在会话中
        session.setAttribute("captcha", token);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 生成验证码图片
            cage.draw(token, baos);
            baos.flush();
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        byte[] imageBytes = baos.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
}
