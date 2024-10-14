package com.rsmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/captcha")
    public ResponseEntity<byte[]> getCaptcha() throws IOException {
        CaptchaService.Captcha captcha = captchaService.generateCaptcha();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.add("Captcha-Token", captcha.getToken());

        return ResponseEntity.ok()
                .headers(headers)
                .body(captcha.getImage());
    }
}
