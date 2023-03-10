package com.integrador.enadejava.domain.exception;


public class EntidadeEmUsoException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }
}