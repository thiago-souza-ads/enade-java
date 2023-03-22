package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.exception.EntidadeEmUsoException;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Role;
import com.integrador.enadejava.domain.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {

    private RoleRepository roleRepository;

    public List<Role> listar() {
        return roleRepository.findAll();
    }

    public Role buscar(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não foi possível encontrar a role com código %d", id)));
    }

    @Transactional
    public Role salvar(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public void excluir(Long id) {
        try {
            roleRepository.deleteById(id);
            roleRepository.flush();
        } catch (DataIntegrityViolationException ex) {
            throw new EntidadeEmUsoException(
                    String.format("A role de código %d não pode ser removida, pois está em uso", id));
        }
    }
}
