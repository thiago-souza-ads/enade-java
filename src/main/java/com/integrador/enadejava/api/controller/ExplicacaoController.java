package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.dto.EvidenciaDto;
import com.integrador.enadejava.domain.model.Explicacao;
import com.integrador.enadejava.domain.service.ExplicacaoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/explicacoes")
public class ExplicacaoController {

    @Autowired
    private ExplicacaoService explicacaoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<EvidenciaDto> buscar(@PathVariable Long id) {
        Explicacao explicacao = explicacaoService.buscarOuFalhar(id);
        EvidenciaDto explicacaoDTO = modelMapper.map(explicacao, EvidenciaDto.class);
        return ResponseEntity.ok(explicacaoDTO);
    }

    @PostMapping
    public ResponseEntity<EvidenciaDto> salvar(@RequestBody @Valid EvidenciaDto explicacaoDTO) {
        Explicacao explicacao = modelMapper.map(explicacaoDTO, Explicacao.class);
        explicacao = explicacaoService.salvar(explicacao);
        explicacaoDTO = modelMapper.map(explicacao, EvidenciaDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(explicacaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvidenciaDto> atualizar(@PathVariable Long id,
                                                  @RequestBody @Valid EvidenciaDto explicacaoDTO) {
        Explicacao explicacaoAtual = explicacaoService.buscarOuFalhar(id);
        BeanUtils.copyProperties(explicacaoDTO, explicacaoAtual);
        explicacaoAtual = explicacaoService.salvar(explicacaoAtual);
        explicacaoDTO = modelMapper.map(explicacaoAtual, EvidenciaDto.class);
        return ResponseEntity.ok(explicacaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            explicacaoService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

