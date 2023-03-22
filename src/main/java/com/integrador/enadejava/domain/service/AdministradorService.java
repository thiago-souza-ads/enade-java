package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.constantes.Constantes;
import com.integrador.enadejava.domain.exception.BusinessException;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Administrador;
import com.integrador.enadejava.domain.model.Aluno;
import com.integrador.enadejava.domain.model.Role;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.AdministradorRepository;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Administrador buscarPorId(Long id) {
        return administradorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Administrador não encontrado"));
    }

    public List<Administrador> listar() {
        return administradorRepository.findAll();
    }

    @Transactional
    public Administrador cadastrar(Administrador administrador) {
        if (administrador.getId() != null) {
            throw new BusinessException("Não é possível cadastrar um administrador já existente");
        }
        Usuario usuario = administrador.getUsuario();
        findRole(administrador, usuario);
        return administradorRepository.save(administrador);
    }

    @Transactional
    public Administrador atualizar(Long id, Administrador administrador) {
        Administrador administradorAtual = buscarPorId(id);
        BeanUtils.copyProperties(administrador, administradorAtual, "id", "usuario");
        return administradorRepository.save(administradorAtual);
    }

    @Transactional
    public void excluir(Long id) {
        try {
            administradorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException("Não é possível excluir um administrador que já foi utilizado em alguma operação");
        } catch (Exception e) {
            throw new EntidadeNaoEncontradaException("Administrador não encontrado");
        }
    }

    private void findRole(Administrador administradorSalvo, Usuario usuario) {
        Role role = roleService.listar().stream().filter(r-> r.getNome().equals(Constantes.ROLE_ALUNO)).findFirst().orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi localizada permissão de Aluno"));
        List<Role> roles = Collections.singletonList(role);
        usuario.setRoles(roles);
        usuarioRepository.save(usuario);
        administradorSalvo.setUsuario(usuario);
    }
}

