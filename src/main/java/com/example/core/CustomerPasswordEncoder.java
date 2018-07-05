package com.example.core;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-7-4 下午1:21
 */
public class CustomerPasswordEncoder implements PasswordEncoder{
    @Override
    public String encode(CharSequence rawPassword) {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        return md5PasswordEncoder.encodePassword(rawPassword.toString(),"hyll");
//        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
//        return md5PasswordEncoder.isPasswordValid(encodedPassword, rawPassword.toString(), "hyll");
        return true;
    }
}
