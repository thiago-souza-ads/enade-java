package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.service.CadastroUsuarioService;
import com.integrador.enadejava.domain.service.LoginService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        Usuario user = (Usuario) cadastroUsuarioService.findByEmail(credentials.get("login"));
            if(user != null){
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    @PermitAll
    @PostMapping("/validar-token")
    public ResponseEntity<?> validarToken(@RequestBody String token) {
        Usuario user = (Usuario) cadastroUsuarioService.findOrFail(1L);
        if(user != null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
