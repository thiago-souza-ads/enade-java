package com.integrador.enadejava.domain.exception;

import com.integrador.enadejava.domain.constantes.Constantes;

public class PermissaoNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public PermissaoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public PermissaoNaoEncontradaException(Long permissaoId) {
        this(String.format(Constantes.PERMISSAO_NAO_ENCONTRADA, permissaoId));
    }
}