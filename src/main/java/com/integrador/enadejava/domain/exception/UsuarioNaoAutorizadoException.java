package com.integrador.enadejava.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UsuarioNaoAutorizadoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsuarioNaoAutorizadoException() {
        super("Usuário ou senha inválidos.");
    }
}
