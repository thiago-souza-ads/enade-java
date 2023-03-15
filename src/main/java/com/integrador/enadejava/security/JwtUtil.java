package com.integrador.enadejava.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    @Value("${jwt.segredo.token}")
    private String segredoToken;

    @Value("${jwt.tempo.de.expiracao.token}")
    private Long tempoExpiracao;

    public String gerarToken(String email, String password) {
	if (email == null || password == null) {
	    throw new RuntimeException("Email e Senha devem ser informados!");
	}
	String subject = email + ":" + password;
	return Jwts.builder().setSubject(subject).setExpiration(new Date(System.currentTimeMillis() + tempoExpiracao)).signWith(SignatureAlgorithm.HS512, segredoToken.getBytes()).compact();
    }

    public boolean isTokenValido(String token) {
	Claims claims = getClaims(token);
	if (claims != null) {
	    String username = claims.getSubject();
	    Date dataExpiracao = claims.getExpiration();
	    Date dataNoMomento = new Date(System.currentTimeMillis());
	    if (username != null && dataExpiracao != null && dataNoMomento.before(dataExpiracao)) {
		return true;
	    }
	}
	return false;
    }

    private Claims getClaims(String token) {
	try {
	    return Jwts.parser().setSigningKey(segredoToken.getBytes()).parseClaimsJws(token).getBody();
	} catch (Exception e) {
	    return null;
	}
    }

    public String getSubject(String token) {
	Claims claims = getClaims(token);
	if (claims != null) {
	    return claims.getSubject();
	}
	return null;
    }

}
