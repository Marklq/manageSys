package com.dd.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        String encodePassword = bCryptPasswordEncoder.encode(password);

        return encodePassword;
    }

    public static void main(String[] args) {
        String str = "java";
        String s = encodePassword(str);
        System.out.println(s);
    }

}
