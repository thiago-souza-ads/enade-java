package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.dto.LoginDto;
import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.service.CadastroUsuarioService;
import com.integrador.enadejava.domain.service.LoginService;
import com.integrador.enadejava.security.JwtGenerator;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:3000", "127.0.0.1"})
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    CadastroUsuarioService cadastroUsuarioService;

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @PermitAll
    @PostMapping("/logar")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            Usuario user = (Usuario) authentication.getPrincipal();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
