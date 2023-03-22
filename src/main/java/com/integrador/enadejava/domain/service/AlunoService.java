package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.constantes.Constantes;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Aluno;
import com.integrador.enadejava.domain.model.Curso;
import com.integrador.enadejava.domain.model.Role;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.AlunoRepository;
import com.integrador.enadejava.domain.repository.CursoRepository;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final RoleService roleService;

    public AlunoService(AlunoRepository alunoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository, RoleService roleService) {
        this.alunoRepository = alunoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.roleService = roleService;
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Aluno não encontrado"));
    }

    @Transactional
    public Aluno cadastrarAluno(Aluno aluno) {
        Usuario usuario = aluno.getUsuario();
        findRole(aluno, usuario);

        Curso curso = cursoRepository.findById(aluno.getCurso().getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Curso não encontrado"));
        aluno.setCurso(curso);

        return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno atualizarAluno(Long id, Aluno aluno) {
        Aluno alunoSalvo = buscarAlunoPorId(id);

        alunoSalvo.setNome(aluno.getNome());

        if (aluno.getUsuario() != null) {
            Usuario usuario = aluno.getUsuario();
            usuario.setId(alunoSalvo.getUsuario().getId());
            findRole(alunoSalvo, usuario);
        }

        if (aluno.getCurso() != null) {
            Curso curso = cursoRepository.findById(aluno.getCurso().getId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException("Curso não encontrado"));
            alunoSalvo.setCurso(curso);
        }

        return alunoRepository.save(alunoSalvo);
    }

    private void findRole(Aluno alunoSalvo, Usuario usuario) {
        Role role = roleService.listar().stream().filter(r-> r.getNome().equals(Constantes.ROLE_ALUNO)).findFirst().orElseThrow(() -> new EntidadeNaoEncontradaException("Não foi localizada permissão de Aluno"));
        List<Role> roles = Collections.singletonList(role);
        usuario.setRoles(roles);
        usuarioRepository.save(usuario);
        alunoSalvo.setUsuario(usuario);
    }

    @Transactional
    public void excluirAluno(Long id) {
        Aluno aluno = buscarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }
}
