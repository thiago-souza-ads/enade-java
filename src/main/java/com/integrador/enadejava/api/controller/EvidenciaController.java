package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.model.Evidencia;
import com.integrador.enadejava.domain.dto.EvidenciaDto;
import com.integrador.enadejava.domain.service.EvidenciaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/evidencias")
public class EvidenciaController {

    @Autowired
    private EvidenciaService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<EvidenciaDto> buscar(@PathVariable Long id) {
        Evidencia evidencia = service.buscarOuFalhar(id);
        EvidenciaDto dto = modelMapper.map(evidencia, EvidenciaDto.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EvidenciaDto> salvar(@RequestBody @Valid EvidenciaDto dto) {
        Evidencia evidencia = modelMapper.map(dto, Evidencia.class);
        Evidencia evidenciaSalva = service.salvar(evidencia);
        EvidenciaDto dtoSalvo = modelMapper.map(evidencia, EvidenciaDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoSalvo);
    }

    @GetMapping
    public List<EvidenciaDto> listar() {
        List<Evidencia> evidencias = service.listar();
        List<EvidenciaDto> evidenciaDTOS = new ArrayList<>();
        evidencias.forEach(evidencia -> evidenciaDTOS.add(modelMapper.map(evidencia, EvidenciaDto.class)));
        return evidenciaDTOS;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

