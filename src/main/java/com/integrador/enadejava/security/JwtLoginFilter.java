package com.integrador.enadejava.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.enadejava.domain.dto.CredenciaisDto;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            CredenciaisDto credenciaisDto = new ObjectMapper().readValue(request.getInputStream(), CredenciaisDto.class);

            CustomAuthenticationToken authToken = new CustomAuthenticationToken(credenciaisDto.getEmail(), credenciaisDto.getSenha(), Collections.emptyList());

            Authentication auth = authenticationManager.authenticate(authToken);

            return auth;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((UsuarioSecurity) authResult.getPrincipal()).getUsername();
        String password = ((UsuarioSecurity) authResult.getPrincipal()).getPassword();

        String jwtToken = jwtUtil.gerarToken(username, password);

        response.addHeader("Authorization", "Bearer " + jwtToken);
        response.addHeader("access-control-expose-headers", "Authorization");
    }

}
