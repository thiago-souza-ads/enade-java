package com.integrador.enadejava.api.controller;

import com.integrador.enadejava.domain.dto.FotoDto;
import com.integrador.enadejava.domain.dto.FotoInputDTO;
import com.integrador.enadejava.domain.service.FotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @GetMapping
    public List<FotoDto> listar() {
        return fotoService.listar();
    }

    @GetMapping("/{id}")
    public FotoDto buscar(@PathVariable Long id) {
        return fotoService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FotoDto salvar(@RequestBody @Valid FotoInputDTO fotoInputDTO) {
        return fotoService.salvar(fotoInputDTO);
    }

    @PutMapping("/{id}")
    public FotoDto atualizar(@PathVariable Long id, @RequestBody @Valid FotoInputDTO fotoInputDTO) {
        return fotoService.atualizar(id, fotoInputDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        fotoService.excluir(id);
    }
}

