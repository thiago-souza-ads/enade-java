package com.integrador.enadejava.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.exception.PermissaoNaoEncontradaException;
import com.integrador.enadejava.domain.model.Permissao;
import com.integrador.enadejava.domain.repository.PermissaoRepository;
import com.integrador.enadejava.domain.service.CadastroPermissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

    @Autowired
    private PermissaoRepository permissaoRepository;
    @Autowired
    private CadastroPermissaoService cadastroPermissaoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Permissao> listar() {
        return permissaoRepository.findAll();
    }

    @GetMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.OK)
    public Permissao buscar(@PathVariable Long permissaoId) {
        return cadastroPermissaoService.findOrFail(permissaoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Permissao adicionar(@RequestBody Permissao permissao) {
        try {
            return cadastroPermissaoService.salvar(permissao);
        } catch (PermissaoNaoEncontradaException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @PutMapping("/{permissaoId}")
    @ResponseStatus(HttpStatus.OK)
    public Permissao atualizar(@PathVariable Long permissaoId, @RequestBody Permissao permissao) {
        Permissao permissaoAtual = cadastroPermissaoService.findOrFail(permissaoId);
        BeanUtils.copyProperties(permissao, permissaoAtual, "id");
        try {
            return cadastroPermissaoService.salvar(permissaoAtual);
        } catch (PermissaoNaoEncontradaException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{permissaoId}")
    public void remover(@PathVariable Long permissaoId) {
        cadastroPermissaoService.excluir(permissaoId);
    }

    @PatchMapping("/{permissaoId}")
    public Permissao atualizarParcial(@PathVariable Long permissaoId, @RequestBody Map<String, Object> campos) {
        Permissao permissaoAtual = cadastroPermissaoService.findOrFail(permissaoId);
        merge(campos, permissaoAtual);
        return atualizar(permissaoId, permissaoAtual);
    }

    private void merge(Map<String, Object> dadosOrigem, Permissao permissaoDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Permissao permissaoOrigem = objectMapper.convertValue(dadosOrigem, Permissao.class);
        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Permissao.class, nomePropriedade);
            field.setAccessible(Boolean.TRUE);
            Object novoValor = ReflectionUtils.getField(field, permissaoOrigem);
            ReflectionUtils.setField(field, permissaoDestino, novoValor);
        });
    }
}