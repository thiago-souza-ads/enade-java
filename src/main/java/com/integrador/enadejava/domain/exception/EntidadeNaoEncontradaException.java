package com.integrador.enadejava.domain.exception;

public class EntidadeNaoEncontradaException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}