package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Administrador;
import com.integrador.enadejava.domain.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> buscarPorId(@PathVariable Long id) {
        Administrador administrador = administradorService.buscarPorId(id);
        return ResponseEntity.ok(administrador);
    }

    @PostMapping
    public ResponseEntity<Administrador> cadastrar(@RequestBody Administrador administrador) {
        administrador = administradorService.cadastrar(administrador);
        return new ResponseEntity<>(administrador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrador> atualizar(@PathVariable Long id, @RequestBody Administrador administrador) {
        administrador = administradorService.atualizar(id, administrador);
        return ResponseEntity.ok(administrador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        administradorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
