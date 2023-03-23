package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.dto.EtapaDto;
import com.integrador.enadejava.domain.model.Etapa;
import com.integrador.enadejava.domain.service.EtapaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/etapas")
public class EtapaController {

    private EtapaService etapaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EtapaDto cadastrar(@RequestBody EtapaDto etapaDTO) {
        Etapa etapa = modelMapper.map(etapaDTO, Etapa.class);
        etapa = etapaService.salvar(etapa);
        return modelMapper.map(etapa, EtapaDto.class);
    }

    @GetMapping("/{id}")
    public EtapaDto buscar(@PathVariable Long id) {
        Etapa etapa = etapaService.buscarOuFalhar(id);
        return modelMapper.map(etapa, EtapaDto.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        etapaService.excluir(id);
    }
}
