package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Professor;
import com.integrador.enadejava.domain.service.ProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listar() {
        return professorService.listar();
    }

    @GetMapping("/{id}")
    public Professor buscar(@PathVariable Long id) {
        return professorService.buscarOuFalhar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor cadastrar(@RequestBody  Professor professor) {
        return professorService.cadastrar(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody  Professor professor) {
        Professor professorAtual = professorService.buscarOuFalhar(id);

        BeanUtils.copyProperties(professor, professorAtual, "id", "usuario");
        return professorService.salvar(professorAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        professorService.remover(id);
    }
}

