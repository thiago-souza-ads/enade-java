package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Etapa;
import com.integrador.enadejava.domain.repository.EtapaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EtapaService {

    private EtapaRepository etapaRepository;

    @Transactional
    public Etapa salvar(Etapa etapa) {
        return etapaRepository.save(etapa);
    }

    public Etapa buscarOuFalhar(Long etapaId) {
        return etapaRepository.findById(etapaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe uma etapa com código %d", etapaId)));
    }

    @Transactional
    public void excluir(Long etapaId) {
        Etapa etapa = buscarOuFalhar(etapaId);

        if (etapa.getQuestionario() != null || etapa.getMidia() != null) {
            throw new BusinessException("Não é possível excluir etapa com questionário ou mídia vinculados");
        }

        etapaRepository.deleteById(etapa.getId());
    }
}
