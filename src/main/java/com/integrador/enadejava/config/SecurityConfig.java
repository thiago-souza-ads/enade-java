package com.integrador.enadejava.config;

import com.integrador.enadejava.security.CustomPasswordEncoder;
import com.integrador.enadejava.security.CustomUserDetailsAuthenticationProvider;
import com.integrador.enadejava.security.CustomUserDetailsService;
import com.integrador.enadejava.security.JwtUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    private static final String[] ACESSOS_SWAGGER = {"/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**"};

    private static final String[] ACESSOS_WEB = {"/login.** /index.html", "/favicon.ico", "/assets/**", "/main.**", "/polyfills.**", "/runtime.**", "/vendor.**", "/styles.**", "/app/**"};

    private static final String[] ACESSOS_PUBLICOS = (String[]) ArrayUtils.addAll(ArrayUtils.addAll(ACESSOS_SWAGGER, ACESSOS_WEB), new String[]{
            "/login/**"
    });

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    public AuthenticationProvider authProvider() {
        CustomUserDetailsAuthenticationProvider provider = new CustomUserDetailsAuthenticationProvider(new CustomPasswordEncoder(), customUserDetailsService);
        return provider;
    }

}
