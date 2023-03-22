package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Questionario;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.QuestionarioRepository;
import com.integrador.enadejava.domain.service.CadastroUsuarioService;
import com.integrador.enadejava.domain.service.LoginService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questionarios")
@CrossOrigin(origins = {"http://localhost:3000", "127.0.0.1"})
public class QuestionarioController {

    @Autowired
    private QuestionarioRepository questionarioRepository;

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @GetMapping
    public ResponseEntity<?> todos (){
        try{
            List<Questionario> questionarios = questionarioRepository.findAll();
            return ResponseEntity.ok(questionarios);
        } catch (Exception e){

        }
        return ResponseEntity.noContent().build();
    }
}
