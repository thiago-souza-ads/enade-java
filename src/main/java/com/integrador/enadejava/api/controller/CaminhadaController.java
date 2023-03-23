package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Caminhada;
import com.integrador.enadejava.domain.service.CaminhadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caminhadas")
public class CaminhadaController {

    @Autowired
    private CaminhadaService caminhadaService;

    @GetMapping("/{caminhadaId}")
    public ResponseEntity<Caminhada> buscar(@PathVariable Long caminhadaId) {
        Caminhada caminhada = caminhadaService.buscarOuFalhar(caminhadaId);
        return ResponseEntity.ok(caminhada);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhada adicionar(@RequestBody Caminhada caminhada) {
        return caminhadaService.salvar(caminhada);
    }

    @PutMapping("/{caminhadaId}")
    public ResponseEntity<Caminhada> atualizar(@RequestBody Caminhada caminhada, @PathVariable Long caminhadaId) {
        Caminhada caminhadaAtual = caminhadaService.buscarOuFalhar(caminhadaId);

        caminhadaAtual.setMapa(caminhada.getMapa());
        caminhadaAtual.setAluno(caminhada.getAluno());

        Caminhada caminhadaAtualizada = caminhadaService.salvar(caminhadaAtual);

        return ResponseEntity.ok(caminhadaAtualizada);
    }

    @DeleteMapping("/{caminhadaId}")
    public ResponseEntity<Void> remover(@PathVariable Long caminhadaId) {
        caminhadaService.excluir(caminhadaId);
        return ResponseEntity.noContent().build();
    }

}


