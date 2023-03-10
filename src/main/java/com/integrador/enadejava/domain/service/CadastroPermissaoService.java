package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.constantes.Constantes;
import com.integrador.enadejava.domain.exception.EntidadeEmUsoException;
import com.integrador.enadejava.domain.exception.PermissaoNaoEncontradaException;
import com.integrador.enadejava.domain.model.Permissao;
import com.integrador.enadejava.domain.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroPermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Transactional
    public Permissao salvar(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    @Transactional
    public void excluir(Long permissaoId) {
        try {
            permissaoRepository.deleteById(permissaoId);
        } catch (EmptyResultDataAccessException e) {
            throw new PermissaoNaoEncontradaException(permissaoId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(Constantes.ENTIDADE_EM_USO, Permissao.class.getName(), permissaoId)
            );
        }
    }

    public Permissao findOrFail(Long permissaoId) {
        return permissaoRepository.findById(permissaoId)
                .orElseThrow(
                        () -> new PermissaoNaoEncontradaException(permissaoId));
    }

}