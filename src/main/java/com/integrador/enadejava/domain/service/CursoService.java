package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.exception.EntidadeEmUsoException;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Curso;
import com.integrador.enadejava.domain.repository.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    @Autowired private  CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void excluir(Long id) {
        try {
            cursoRepository.deleteById(id);
            cursoRepository.flush();
        } catch (EmptyResultDataAccessException ex) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um curso com o código %d", id));
        } catch (DataIntegrityViolationException ex) {
            throw new EntidadeEmUsoException(
                    String.format("Curso de código %d não pode ser removido, pois está em uso", id));
        }
    }

    @Transactional
    public Curso atualizar(Long id, Curso curso) {
        Curso cursoAtual = buscarOuFalhar(id);

        BeanUtils.copyProperties(curso, cursoAtual, "id");

        return salvar(cursoAtual);
    }

    public Curso buscarOuFalhar(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe um curso com o código %d", id)));
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

}

