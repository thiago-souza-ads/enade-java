package com.integrador.enadejava.security;

import java.util.Optional;

import com.integrador.enadejava.domain.model.Usuario;
import com.integrador.enadejava.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails loadUserByEmailAndPassword(String email, String password) throws UsernameNotFoundException {
	Optional<Usuario> optionalUsuario = usuarioRepository.findByEmailAndSenhaAndAtivo(email, password, true);

	Usuario usuario = optionalUsuario.orElseThrow(() -> new UsernameNotFoundException(email));

	return new UsuarioSecurity(usuario);
    }

}
