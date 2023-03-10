package com.integrador.enadejava.domain.service;

import com.integrador.enadejava.domain.dto.LoginDto;
import com.integrador.enadejava.domain.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public Boolean autenticar(Usuario usuario, String senha) {
        return usuario.getSenha().equals(senha);
    }
}
