package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.api.controller.CoordenadorController;
import com.integrador.enadejava.domain.constantes.Constantes;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.*;
import com.integrador.enadejava.domain.repository.CoordenadorRepository;
import com.integrador.enadejava.domain.repository.CursoRepository;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CoordenadorService {

    private final CoordenadorRepository coordenadorRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    public CoordenadorService(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    public List<Coordenador> listarCoordenadores() {
        return coordenadorRepository.findAll();
    }

    public Coordenador cadastrarCoordenador(Coordenador coordenador) {
        Usuario usuario = coordenador.getUsuario();
        findRole(coordenador, usuario);
        Curso curso = cursoRepository.findById(coordenador.getCurso().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Curso não encontrado"));
        coordenador.setCurso(curso);
        return coordenadorRepository.save(coordenador);
    }

    public Optional<Coordenador> buscarCoordenador(Long id) {
        return coordenadorRepository.findById(id);
    }

    public Coordenador atualizarCoordenador(Long id, Coordenador coordenadorAtualizado) {
        Coordenador coordenador = coordenadorRepository.findById(id).orElse(null);

        if (coordenador == null) {
            throw new EntidadeNaoEncontradaException("Coordenador não encontrado com id: " + id);
        }

        coordenador.setNome(coordenadorAtualizado.getNome());
        coordenador.setUsuario(coordenadorAtualizado.getUsuario());

        return coordenadorRepository.save(coordenador);
    }

    public void excluirCoordenador(Long id) {
        Coordenador coordenador = coordenadorRepository.findById(id).orElse(null);

        if (coordenador == null) {
            throw new EntidadeNaoEncontradaException("Coordenador não encontrado com id: " + id);
        }

        coordenadorRepository.delete(coordenador);
    }
    private void findRole(Coordenador coordenadorSalvo, Usuario usuario) {
        Role role = roleService.listar().stream().filter(r-> r.getNome().equals(Constantes.ROLE_COORDENADOR)).findFirst().orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi localizada permissão de Aluno"));
        List<Role> roles = Collections.singletonList(role);
        usuario.setRoles(roles);
        usuarioRepository.save(usuario);
        coordenadorSalvo.setUsuario(usuario);
    }
}

