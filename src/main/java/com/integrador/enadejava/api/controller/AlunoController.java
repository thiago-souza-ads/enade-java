package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Aluno;
import com.integrador.enadejava.domain.service.AlunoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id) {
        try {
            Aluno aluno = alunoService.buscarAlunoPorId(id);
            return ResponseEntity.ok(aluno);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno cadastrar(@RequestBody @Valid Aluno aluno) {
        try {
            return alunoService.cadastrarAluno(aluno);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Usuário já possui um aluno cadastrado.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
        try {
            Aluno alunoAtual = alunoService.buscarAlunoPorId(id);
            aluno.setId(alunoAtual.getId());
            return ResponseEntity.ok(alunoService.cadastrarAluno(aluno));
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Usuário já possui um aluno cadastrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        try {
            alunoService.excluirAluno(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Não é possível remover o aluno pois existem registros dependentes.");
        }
    }

}
