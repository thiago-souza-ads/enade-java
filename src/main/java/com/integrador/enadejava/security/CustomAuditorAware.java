package com.integrador.enadejava.security;

import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class CustomAuditorAware implements AuditorAware<Usuario> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> getCurrentAuditor() {
        if (SecurityContextHolder.getContext() == null || SecurityContextHolder.getContext().getAuthentication() == null || SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null) {

            Optional<Usuario> usuarioAnonimo = this.usuarioRepository.findById(1L); // 3 - Id do usuário anônimo
            return usuarioAnonimo;
        }

        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UsuarioSecurity) {
            UsuarioSecurity usuarioSecurity = (UsuarioSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Usuario usuarioLogado = new Usuario();
            usuarioLogado.setId(usuarioSecurity.getId());
            usuarioLogado.setNome(usuarioSecurity.getNome());

            return Optional.ofNullable(usuarioLogado);
        } else {
            return Optional.ofNullable(new Usuario());
        }
    }

}
