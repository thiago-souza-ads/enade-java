package com.integrador.enadejava.domain.service;

import java.util.List;
import java.util.Optional;

import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Alternativa;
import com.integrador.enadejava.domain.repository.AlternativaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;

    @Transactional
    public Alternativa salvar(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    public List<Alternativa> buscarTodas() {
        return alternativaRepository.findAll();
    }

    public Alternativa buscarPorId(Long id) {
        return alternativaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Alternativa não encontrada"));
    }

    @Transactional
    public void excluir(Long id) {
        alternativaRepository.deleteById(id);
    }

    @Transactional
    public Alternativa cadastrarAlternativa(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    @Transactional
    public Alternativa atualizarAlternativa(Long id, Alternativa alternativaAtualizada) {
        Optional<Alternativa> optionalAlternativa = alternativaRepository.findById(id);

        if (optionalAlternativa.isPresent()) {
            Alternativa alternativa = optionalAlternativa.get();
            alternativa.setDescricao(alternativaAtualizada.getDescricao());
            alternativa.setOrdem(alternativaAtualizada.getOrdem());
            alternativa.setCorreta(alternativaAtualizada.getCorreta());
            alternativa.setExplicacao(alternativaAtualizada.getExplicacao());
            return alternativaRepository.save(alternativa);
        } else {
            throw new EntidadeNaoEncontradaException("Alternativa não encontrada com o ID: " + id);
        }
    }
}

