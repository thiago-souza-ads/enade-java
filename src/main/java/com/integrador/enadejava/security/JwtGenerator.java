package com.integrador.enadejava.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtGenerator {
    private static final long EXPIRATION_TIME = 86400000; // 24 horas em milissegundos

    private static final String SECRET_KEY = "enade-cd74bb7d000e84d86c752aa8b48e8f76-thiago"; // Chave secreta para assinar o token

    public static String generateToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}