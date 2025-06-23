package com.hcl.AuthorDemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OtpDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private final String SAVE_OTP = "insert into otp(email,otp,timestamp) values(:email,:otp,:timestamp)";
    private final String GET_OTP = "select otp,timestamp from otp where otp.email=:email ORDER BY timestamp DESC LIMIT 1";

    public void saveOtp(String email, int otp) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        paramMap.put("otp", otp);
        paramMap.put("timestamp", LocalDateTime.now());
        jdbcTemplate.update(SAVE_OTP, paramMap);
    }

    public Map<String, Object> getOtp(String email) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        return jdbcTemplate.queryForMap(GET_OTP, paramMap);
    }
}
