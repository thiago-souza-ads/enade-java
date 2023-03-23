package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Coordenador;
import com.integrador.enadejava.domain.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coordenadores")
public class CoordenadorController {

    @Autowired
    private  CoordenadorService coordenadorService;

    public CoordenadorController(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }

    @GetMapping
    public List<Coordenador> listarCoordenadores() {
        return coordenadorService.listarCoordenadores();
    }

    @PostMapping
    public ResponseEntity<Coordenador> cadastrarCoordenador(@RequestBody Coordenador coordenador) {
        Coordenador novoCoordenador = coordenadorService.cadastrarCoordenador(coordenador);
        return ResponseEntity.created(getUri(novoCoordenador)).body(novoCoordenador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordenador> buscarCoordenador(@PathVariable Long id) {
        Optional<Coordenador> coordenador = coordenadorService.buscarCoordenador(id);
        return coordenador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordenador> atualizarCoordenador(@PathVariable Long id, @RequestBody Coordenador coordenador) {
        Coordenador coordenadorAtualizado = coordenadorService.atualizarCoordenador(id, coordenador);
        return ResponseEntity.ok(coordenadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCoordenador(@PathVariable Long id) {
        coordenadorService.excluirCoordenador(id);
        return ResponseEntity.noContent().build();
    }

    private URI getUri(Coordenador coordenador) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(coordenador.getId()).toUri();
    }

}

