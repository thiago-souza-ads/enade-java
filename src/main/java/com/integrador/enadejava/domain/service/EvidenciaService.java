package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Caminhada;
import com.integrador.enadejava.domain.model.Evidencia;
import com.integrador.enadejava.domain.repository.EvidenciaRepository;
import com.integrador.enadejava.domain.service.CaminhadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvidenciaService {

    @Autowired
    private EvidenciaRepository repository;

    @Autowired
    private CaminhadaService caminhadaService;

    public Evidencia buscarOuFalhar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Evidência não encontrada"));
    }

    public Evidencia salvar(Evidencia evidencia) {
        Caminhada caminhada = caminhadaService.buscarOuFalhar(evidencia.getCaminhada().getId());
        evidencia.setCaminhada(caminhada);
        return repository.save(evidencia);
    }

    public List<Evidencia> listar() {
        return repository.findAll();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
