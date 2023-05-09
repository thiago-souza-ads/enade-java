package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.dto.AvatarDto;
import com.integrador.enadejava.domain.dto.UsuarioDto;
import com.integrador.enadejava.domain.exception.EntidadeNaoEncontradaException;
import com.integrador.enadejava.domain.model.Avatar;
import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    ModelMapper modelMapper;

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

    public void atualizarAvatar(UsuarioDto usuarioDto) {
        Usuario usuario = findById(usuarioDto.getId());
        Avatar avatar = modelMapper.map(usuarioDto.getAvatar(), Avatar.class);
        usuario.setAvatar(avatar);
        update(usuario);
    }
}
