package com.integrador.enadejava.domain.exception;
import com.integrador.enadejava.domain.constantes.Constantes;

public class GrupoNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public GrupoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public GrupoNaoEncontradaException(Long grupoId) {
        this(String.format(Constantes.GRUPO_NAO_ENCONTRADO, grupoId));
    }
}