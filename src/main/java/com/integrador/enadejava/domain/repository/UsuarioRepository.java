package com.integrador.enadejava.domain.repository;


import com.integrador.enadejava.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLoginEquals(String email);

    Optional<Usuario> findByEmailAndSenhaAndAtivo(String email, String hashSenha, Boolean isAtivo);

}