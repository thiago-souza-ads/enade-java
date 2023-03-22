package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.constantes.Constantes;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Curso;
import com.integrador.enadejava.domain.model.Professor;
import com.integrador.enadejava.domain.model.Role;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.CursoRepository;
import com.integrador.enadejava.domain.repository.ProfessorRepository;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @Autowired
    private RoleService roleService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Professor> listar() {
        return professorRepository.findAll();
    }

    public Professor buscarOuFalhar(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Professor não encontrado com ID " + id));
    }

    @Transactional
    public Professor cadastrar(Professor professor) {
        Usuario usuario = professor.getUsuario();
        findRole(professor, usuario);

        Curso curso = cursoRepository.findById(professor.getCurso().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Curso não encontrado"));
        professor.setCurso(curso);

        return professorRepository.save(professor);
    }

    @Transactional
    public Professor salvar(Professor professor) {
        Curso curso = cursoRepository.findById(professor.getCurso().getId())
                .orElseThrow(() -> new DataIntegrityViolationException("Curso não encontrado com ID " + professor.getCurso().getId()));

        professor.setCurso(curso);
        return professorRepository.save(professor);
    }

    @Transactional
    public void remover(Long id) {
        professorRepository.delete(buscarOuFalhar(id));
    }


    private void findRole(Professor professorSalvo, Usuario usuario) {
        Role role = roleService.listar().stream().filter(r -> r.getNome().equals(Constantes.ROLE_ALUNO)).findFirst().orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi localizada permissão de Aluno"));
        List<Role> roles = Collections.singletonList(role);
        usuario.setRoles(roles);
        usuarioRepository.save(usuario);
        professorSalvo.setUsuario(usuario);
    }

}

