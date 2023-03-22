package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.exception.EntidadeEmUsoException;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Role;
import com.integrador.enadejava.domain.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public List<Role> listar() {
        return roleService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> buscar(@PathVariable Long id) {
        try {
            Role role = roleService.buscar(id);
            return ResponseEntity.ok(role);
        } catch (EntidadeNaoEncontradaException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role adicionar(@RequestBody @Valid Role role) {
        return roleService.salvar(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> atualizar(@PathVariable Long id, @RequestBody @Valid Role role) {
        try {
            Role roleAtual = roleService.buscar(id);
            role.setId(roleAtual.getId());
            roleService.salvar(role);
            return ResponseEntity.ok(role);
        } catch (EntidadeNaoEncontradaException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        try {
            roleService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException ex) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
