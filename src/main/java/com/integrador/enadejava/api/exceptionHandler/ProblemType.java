package com.integrador.enadejava.api.exceptionHandler;

import com.integrador.enadejava.domain.constantes.Constantes;
import lombok.Getter;

@Getter
public enum ProblemType {

    ENTIDADE_NAO_ENCONTRADA(Constantes.PATCH_ENTIDADE_NAO_ENCONTRADA, Constantes.TITLE_ENTIDADE_NAO_ENCONTRADA),

    BUSINESS_EXCEPTION(Constantes.PATCH_BUSINESS_EXCEPTION, Constantes.TITLE_BUSINESS_EXCEPTION),

    ENTIDADE_ENTIDADE_EM_USO(Constantes.PATCH_ENTIDADE_EM_USO, Constantes.TITLE_ENTIDADE_EM_USO),

    CAMPO_OBRIGATORIO(Constantes.PATCH_CAMPO_OBRIGATORIO, Constantes.TITLE_CAMPO_OBRIGATORIO),

    MENSAGEM_INCOMPREENSIVEL(Constantes.PATCH_MENSAGEM_INCOMPREENSIVEL, Constantes.TITLE_MENSAGEM_INCOMPREENSIVEL),

    URL_INXEXISTENTE(Constantes.PATCH_URL_INXEXISTENTE, Constantes.TITLE_URL_INXEXISTENTE),

    ERRO_DE_SISTEMA(Constantes.PATCH_ERRO_DE_SISTEMA, Constantes.TITLE_ERRO_DE_SISTEMA),

    CAMPO_INVALIDO(Constantes.PATCH_CAMPO_OBRIGATORIO, Constantes.TITLE_CAMPO_OBRIGATORIO),

    PARAMETRO_INVALIDO(Constantes.PATCH_PARAMETRO_INVALIDO, Constantes.TITLE_PARAMETRO_URL_INVALIDO);

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = Constantes.URI + path;
        this.title = title;
    }
}
