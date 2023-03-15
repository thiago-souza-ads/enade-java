package com.integrador.enadejava.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.util.Base64;

public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(rawPassword.toString().getBytes("UTF-8"));

            return Base64.getEncoder().encodeToString(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException("Não é possível gerar hashEncode da senha.");
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return new CustomPasswordEncoder().encode(rawPassword).equals(encodedPassword);
    }

}
