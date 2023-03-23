package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.dto.CursoDto;
import com.integrador.enadejava.domain.model.Curso;
import com.integrador.enadejava.domain.service.CursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CursoDto> listar() {
        List<Curso> cursos = cursoService.listar();
        return cursos.stream()
                .map(curso -> modelMapper.map(curso, CursoDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> buscar(@PathVariable Long id) {
        Curso curso = cursoService.buscarOuFalhar(id);
        if (curso != null) {
            CursoDto cursoDTO = modelMapper.map(curso, CursoDto.class);
            return ResponseEntity.ok(cursoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDto adicionar(@RequestBody @Valid CursoDto cursoDTO) {
        Curso curso = modelMapper.map(cursoDTO, Curso.class);
        curso = cursoService.salvar(curso);
        return modelMapper.map(curso, CursoDto.class);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> atualizar(@PathVariable Long id, @RequestBody @Valid CursoDto cursoDTO) {
        if (cursoService.buscarOuFalhar(id) == null) {
            return ResponseEntity.notFound().build();
        }
        Curso curso = modelMapper.map(cursoDTO, Curso.class);
        curso.setId(id);
        curso = cursoService.atualizar(id, curso);
        return ResponseEntity.ok(modelMapper.map(curso, CursoDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (cursoService.buscarOuFalhar(id) == null) {
            return ResponseEntity.notFound().build();
        }
        cursoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
