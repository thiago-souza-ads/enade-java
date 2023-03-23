package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.repository.ExplicacaoRepository;
import com.integrador.enadejava.domain.service.ExplicacaoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/explicacoes")
public class ExplicacaoController {

    @Autowired
    private ExplicacaoService explicacaoService;

    @Autowired
    private ExplicacaoRepository explicacaoRepository;


    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(explicacaoRepository.findAll());
    }
}

