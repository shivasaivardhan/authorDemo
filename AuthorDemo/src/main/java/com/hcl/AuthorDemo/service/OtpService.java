package com.hcl.AuthorDemo.service;

import com.hcl.AuthorDemo.dao.OtpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    OtpDao otpDao;

    public int getOTP() {
        return 100000 + new Random().nextInt(999999);
    }

    public void saveOtp(String email, int otp) {
        otpDao.saveOtp(email, otp);
    }

    public boolean fetchVerifyOtp(String email, int otp) {
        Map<String, Object> objectMap = otpDao.getOtp(email);
        if (((int) objectMap.get("otp") == otp) && Duration.between((Temporal) LocalDateTime.now(), (Temporal) objectMap.get("timestamp")).toMinutes() < 5)
            return true;
        return false;
    }
}
