package com.mobile.otp.service;

import com.mobile.otp.model.SMS;

public interface SMSService {

    String sendOTPSMS(SMS sms);

    String verifyOTP(Integer otp);

}
