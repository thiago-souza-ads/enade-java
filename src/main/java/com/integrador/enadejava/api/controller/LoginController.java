package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.dto.LoginDto;
import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.exception.GrupoNaoEncontradaException;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.service.CadastroUsuarioService;
import com.integrador.enadejava.domain.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    CadastroUsuarioService cadastroUsuarioService;

    @PostMapping("/logar")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        Boolean autenticado;
        String email = credentials.get("email");
        String password = credentials.get("password");
        LoginDto loginDto = new LoginDto(email, password);
        try {
            try{
                Usuario user = cadastroUsuarioService.findByEmail(email);
                autenticado = loginService.autenticar(user, password);
                if(autenticado){
                    return ResponseEntity.ok(user);
                } else {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
                }
            } catch (Exception e){

            }
        } catch (GrupoNaoEncontradaException e) {
            throw new BusinessException(e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
