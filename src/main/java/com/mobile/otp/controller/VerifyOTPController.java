package com.mobile.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.otp.service.SMSService;

@RestController
public class VerifyOTPController {
    
    @Autowired
    SMSService service;
    
    @PostMapping("/verify")
    public String verifyOTP(@RequestParam Integer otp) {
        return service.verifyOTP(otp);
    }
}
