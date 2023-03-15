package com.integrador.enadejava.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

public class JwtAutorizacaoFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil;
    private CustomUserDetailsService userDetailsService;

    public JwtAutorizacaoFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            UsernamePasswordAuthenticationToken authToken = getAutenticacao(authorizationHeader.substring(7));
            if (authToken != null) {
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        chain.doFilter(request, response);
    }

    private CustomAuthenticationToken getAutenticacao(String token) {
        if (jwtUtil.isTokenValido(token)) {
            String subject = jwtUtil.getSubject(token);
            String[] subjectArr = subject.split(":");

            String email = subjectArr[0];
            String password = subjectArr[1];

            UserDetails userDetails = userDetailsService.loadUserByEmailAndPassword(email, password);

            return new CustomAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        }
        return null;
    }

}
