package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Caminhada;
import com.integrador.enadejava.domain.repository.CaminhadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaminhadaService {

    @Autowired
    private CaminhadaRepository caminhadaRepository;

    @Transactional
    public Caminhada salvar(Caminhada caminhada) {
        return caminhadaRepository.save(caminhada);
    }

    public Caminhada buscarOuFalhar(Long caminhadaId) {
        return caminhadaRepository.findById(caminhadaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Caminhada de id %d não encontrada", caminhadaId)));
    }

    @Transactional
    public void excluir(Long caminhadaId) {
        try {
            caminhadaRepository.deleteById(caminhadaId);
            caminhadaRepository.flush();
        } catch (DataIntegrityViolationException ex) {
            throw new BusinessException(
                    String.format("Não foi possível excluir a caminhada de id %d, pois está em uso", caminhadaId));
        }
    }

}


