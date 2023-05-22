package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Alternativa;
import com.integrador.enadejava.domain.service.AlternativaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternativas")
@RequiredArgsConstructor
public class AlternativaController {

    @Autowired
    private AlternativaService alternativaService;

    @GetMapping("/{id}")
    public ResponseEntity<Alternativa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alternativaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Alternativa>> listar() {
        return ResponseEntity.ok(alternativaService.buscarTodas());
    }

    @PostMapping
    public ResponseEntity<Alternativa> cadastrar(@RequestBody @Valid Alternativa alternativa) {
        return ResponseEntity.ok(alternativaService.cadastrarAlternativa(alternativa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alternativa> atualizar(@PathVariable Long id, @RequestBody @Valid Alternativa alternativa) {
        return ResponseEntity.ok(alternativaService.atualizarAlternativa(id, alternativa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        alternativaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

