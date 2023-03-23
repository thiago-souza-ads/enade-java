package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Explicacao;
import com.integrador.enadejava.domain.repository.ExplicacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExplicacaoService {

    @Autowired
    private  ExplicacaoRepository explicacaoRepository;

    public Explicacao buscarOuFalhar(Long id) {
        return explicacaoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Explicação de id %d não encontrada", id)));
    }

    public Explicacao salvar(Explicacao explicacao) {
        return explicacaoRepository.save(explicacao);
    }

    public void excluir(Long id) {
        explicacaoRepository.deleteById(id);
    }
}

