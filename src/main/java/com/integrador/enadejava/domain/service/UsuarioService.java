package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario) {
        usuario.setDataCadastro(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));
    }

    public Usuario update(Usuario usuario) {
        Usuario usuarioExistente = findById(usuario.getId());
        usuario.setDataCadastro(usuarioExistente.getDataCadastro());
        usuario.setDataAtualizacao(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }
}
