package com.mobile.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.otp.model.SMS;
import com.mobile.otp.service.SMSService;

@RestController
public class SMSController {
    
    @Autowired
    SMSService service;
    
    @PostMapping("/send")
    public String sendOTP(@RequestBody SMS sms) {
        return service.sendOTPSMS(sms);
    }

}
