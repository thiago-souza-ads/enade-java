package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.constantes.Constantes;
import com.integrador.enadejava.domain.exception.EntidadeEmUsoException;
import com.integrador.enadejava.domain.exception.GrupoNaoEncontradaException;
import com.integrador.enadejava.domain.model.Grupo;
import com.integrador.enadejava.domain.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public Grupo salvar(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    @Transactional
    public void excluir(Long grupoId) {
        try {
            grupoRepository.deleteById(grupoId);
        } catch (EmptyResultDataAccessException e) {
            throw new GrupoNaoEncontradaException(grupoId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(Constantes.ENTIDADE_EM_USO, Grupo.class.getName(), grupoId)
            );
        }
    }

    public Grupo findOrFail(Long grupoId) {
        return grupoRepository.findById(grupoId)
                .orElseThrow(
                        () -> new GrupoNaoEncontradaException(grupoId));
    }

}