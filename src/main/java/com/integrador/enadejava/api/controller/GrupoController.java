package com.integrador.enadejava.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.exception.GrupoNaoEncontradaException;
import com.integrador.enadejava.domain.model.Grupo;
import com.integrador.enadejava.domain.repository.GrupoRepository;
import com.integrador.enadejava.domain.service.CadastroGrupoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private CadastroGrupoService cadastroGrupoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Grupo> listar() {
        return grupoRepository.findAll();
    }

    @GetMapping("/{grupoId}")
    @ResponseStatus(HttpStatus.OK)
    public Grupo buscar(@PathVariable Long grupoId) {
        return cadastroGrupoService.findOrFail(grupoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo adicionar(@RequestBody Grupo grupo) {
        try {
            return cadastroGrupoService.salvar(grupo);
        } catch (GrupoNaoEncontradaException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @PutMapping("/{grupoId}")
    public Grupo atualizar(@PathVariable Long grupoId, @RequestBody Grupo grupo) {
        Grupo grupoAtual = cadastroGrupoService.findOrFail(grupoId);
        BeanUtils.copyProperties(grupo, grupoAtual, "id");
        try {
            return cadastroGrupoService.salvar(grupoAtual);
        } catch (GrupoNaoEncontradaException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @PatchMapping("/{grupoAtual}")
    public Grupo atualizarParcial(@PathVariable Long grupoId, @RequestBody Map<String, Object> campos) {
        Grupo grupoAtual = cadastroGrupoService.findOrFail(grupoId);
        merge(campos, grupoAtual);
        return atualizar(grupoId, grupoAtual);
    }

    private void merge(Map<String, Object> dadosOrigem, Grupo grupoDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Grupo grupoOrigem = objectMapper.convertValue(dadosOrigem, Grupo.class);

        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Grupo.class, nomePropriedade);
            field.setAccessible(Boolean.TRUE);

            Object novoValor = ReflectionUtils.getField(field, grupoOrigem);

            System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor + "\n");
            ReflectionUtils.setField(field, grupoDestino, novoValor);
        });
    }

    @DeleteMapping("/{grupoId}")
    public void remover(@PathVariable Long grupoId) {
        cadastroGrupoService.excluir(grupoId);
    }

}