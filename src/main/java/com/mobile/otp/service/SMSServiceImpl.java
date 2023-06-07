package com.mobile.otp.service;

import org.springframework.stereotype.Service;

import com.mobile.otp.model.OTP;
import com.mobile.otp.model.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSServiceImpl implements SMSService {

    public static final String ACCOUNT_SID = "ACf1346aacca3c2a60c43b0eb1d432e6fc";

    public static final String AUTH_TOKEN = "2eb142bc6cfc3b108b80d48b155db877";

    public static final String FROM_NUMBER = "+13204387437";

    @Override
    public String sendOTPSMS(SMS sms) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        int min = 100000;
        int max = 999999;
        int otp = (int) (Math.random() * (max - min + 1) + min);

        String otpmessage = "Your OTP " + otp + " please verify this OTP ";

        Message message = Message
                .creator(new PhoneNumber(sms.getPhoneNumber()), new PhoneNumber(FROM_NUMBER), otpmessage).create();

        OTP.setTempOTP(otp);

        System.out.println(message.getSid());
        return "OTP is Successfully sent to your mobile  " + sms.getPhoneNumber() + " OTP is   " + otp + " message Id "
                + message.getSid();

    }

    @Override
    public String verifyOTP(Integer otp) {
        if (OTP.getTempOTP() == otp)
            return "OTP is Successfully verified...";
        else
            return "OTP verification failed";
    }

}
